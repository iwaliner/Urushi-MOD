package com.iwaliner.urushi.block;
import com.iwaliner.urushi.BlockEntityRegister;
import com.iwaliner.urushi.blockentity.SacredRockBlockEntity;
import com.iwaliner.urushi.blockentity.ShichirinBlockEntity;
import com.iwaliner.urushi.util.ElementType;
import com.iwaliner.urushi.util.UrushiUtils;
import com.iwaliner.urushi.util.interfaces.ElementBlock;
import com.iwaliner.urushi.util.interfaces.Tiered;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SacredRockBlock extends BaseEntityBlock implements Tiered, ElementBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    private static final VoxelShape BOX = Block.box(2D, 0.0D, 2D, 14D, 5D, 14D);
    private ElementType elementType;
    public SacredRockBlock(ElementType type,Properties p_i48377_1_) {
        super(p_i48377_1_);
        elementType=type;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Nullable
    @Override
    public int getTier() {
        return 1;    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return BOX;
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return   new SacredRockBlockEntity(pos,state);
    }

    public RenderShape getRenderShape(BlockState p_49090_) {
        return RenderShape.MODEL;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49915_) {
        p_49915_.add(FACING);
    }
    @Override
    public BlockState rotate(BlockState state, LevelAccessor level, BlockPos pos, Rotation direction) {
        return state.setValue(FACING, direction.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }


    @Override
    public void appendHoverText(ItemStack p_49816_, @org.jetbrains.annotations.Nullable BlockGetter p_49817_, List<Component> list, TooltipFlag p_49819_) {
        UrushiUtils.setInfo(list,"scared_rock");
    }

    @Override
    public ElementType getElementType() {
        return elementType;
    }
    @javax.annotation.Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152160_, BlockState p_152161_, BlockEntityType<T> p_152162_) {
        return createTickerHelper(p_152162_, BlockEntityRegister.SacredRock.get(), SacredRockBlockEntity::tick);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if(level.getBlockEntity(pos) instanceof SacredRockBlockEntity){
            SacredRockBlockEntity blockEntity= (SacredRockBlockEntity) level.getBlockEntity(pos);
            player.displayClientMessage(new TranslatableComponent("info.urushi.sacred_rock.message").append("  "+blockEntity.getStoredReiryoku()).append(level.isClientSide()? " client":" server"),false);
        return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }
}
