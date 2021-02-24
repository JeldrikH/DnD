package jeldrik.dnd.client.render.tileentity;

import javax.annotation.Nullable;

import jeldrik.dnd.core.init.BlockInit;
import jeldrik.dnd.core.init.ModTileEntityTypes;
import jeldrik.dnd.core.util.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

public class QuarryTileEntity extends TileEntity implements ITickableTileEntity {

	public int x, y, z, tick;
	boolean initialized = false;
	BlockPos pos2;

	public QuarryTileEntity(final TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}

	public QuarryTileEntity() {
		this(ModTileEntityTypes.QUARRY.get());
	}

	@Override
	public void tick() {

		if (!initialized)
			init();
		tick++;
		if (tick%1 == 0) {
			int a = (int) (Math.random() * 3) - 1;
			int b = (int) (Math.random() * 3) - 1;
			int c = (int) (Math.random() * 3) - 1;
			pos2 = pos2.add(a, b, c);
			if(!pos2.getCoordinatesAsString().equals(pos.getCoordinatesAsString()))
			world.setBlockState(pos2, Blocks.WHITE_WOOL.getDefaultState());
		}
		if (tick == 40) {
			tick = 0;
			if (y > 2)
				execute();
			else {
				world.setBlockState(this.pos, Blocks.ACACIA_FENCE_GATE.getDefaultState());
				world.setBlockState(this.pos.add(3, 0, 0), BlockInit.QUARRY.get().getDefaultState());
			}
		}

	}

	private void init() {

		initialized = true;

		x = this.pos.getX() - 1;
		y = this.pos.getY() - 1;
		z = this.pos.getZ() - 1;
		pos2 = this.pos;
		tick = 0;
	}

	private void execute() {
		int index = 0;
		Block[] blocksRemoved = new Block[9];
		for (int x = 0; x < 3; x++) {
			for (int z = 0; z < 3; z++) {
				BlockPos posToBreak = new BlockPos(this.x + x, this.y, this.z + z);
				blocksRemoved[index] = this.world.getBlockState(posToBreak).getBlock();
				destroyBlock(posToBreak, true, null);
				index++;
			}
		}
		this.y--;
	}

	private boolean destroyBlock(BlockPos posToBreak, boolean dropBlock, @Nullable Entity entity) {
		BlockState blockState = world.getBlockState(posToBreak);
		FluidState iFluidState = world.getFluidState(posToBreak);
		world.playEvent(2001, posToBreak, Block.getStateId(blockState));
		if (dropBlock) {
			TileEntity tileEntity = blockState.hasTileEntity() ? world.getTileEntity(posToBreak) : null;
			ItemStack silkTouch = new ItemStack((Item) null);
			silkTouch.addEnchantment(Enchantments.SILK_TOUCH, 1);
			Block.spawnDrops(blockState, world, this.pos.add(0, 1.5, 0), tileEntity, entity, silkTouch);
		}
		return world.setBlockState(posToBreak, iFluidState.getBlockState(), 3);
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		compound.put("initvalues", NBTHelper.toNBT(this));
		return super.write(compound);
	}

	@Override
	public void read(BlockState state, CompoundNBT compound) {
		super.read(state, compound);
		CompoundNBT initValues = compound.getCompound("initvalues");
		if (initValues != null) {
			this.x = initValues.getInt("x");
			this.y = initValues.getInt("y");
			this.z = initValues.getInt("z");
			this.tick = 0;
			initialized = true;
			return;
		}
		init();
	}
}
