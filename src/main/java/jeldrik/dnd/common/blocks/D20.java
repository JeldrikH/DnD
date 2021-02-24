package jeldrik.dnd.common.blocks;

import jeldrik.dnd.core.init.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class D20 extends BaseHorizontalBlock {

	private static final VoxelShape SHAPE = 
			VoxelShapes.combineAndSimplify(Block.makeCuboidShape(4, 0, 4, 12, 8, 12),
			VoxelShapes.combineAndSimplify(Block.makeCuboidShape(4, 7, 4, 5, 8, 5), 
			VoxelShapes.combineAndSimplify(Block.makeCuboidShape(4, 7, 11, 5, 8, 12),
			VoxelShapes.combineAndSimplify(Block.makeCuboidShape(11, 7, 11, 12, 8, 12),
			VoxelShapes.combineAndSimplify(Block.makeCuboidShape(11, 7, 4, 12, 8, 5),
			VoxelShapes.combineAndSimplify(Block.makeCuboidShape(11, 0, 4, 12, 1, 5),
			VoxelShapes.combineAndSimplify(Block.makeCuboidShape(11, 0, 11, 12, 1, 12),
			VoxelShapes.combineAndSimplify(Block.makeCuboidShape(4, 0, 11, 5, 1, 12),
			Block.makeCuboidShape(4, 0, 4, 5, 1, 5),
			IBooleanFunction.NOT_SAME),
			IBooleanFunction.NOT_SAME),
			IBooleanFunction.NOT_SAME),
			IBooleanFunction.NOT_SAME),
			IBooleanFunction.NOT_SAME),
			IBooleanFunction.NOT_SAME), 
			IBooleanFunction.NOT_SAME),
			IBooleanFunction.NOT_SAME);

	public D20(Properties properties) {
		super(properties);
		runCalculation(SHAPE);
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPES.get(this).get(state.get(HORIZONTAL_FACING));
	}
	

}
