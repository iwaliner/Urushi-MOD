package com.iwaliner.urushi;

import com.iwaliner.urushi.block.FryerBlock;
import com.iwaliner.urushi.block.InvisibleButtonBlock;
import com.iwaliner.urushi.block.InvisiblePressurePlateBlock;
import com.iwaliner.urushi.blockentity.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = ModCoreUrushi.ModID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockEntityRegister {
    public static final DeferredRegister<BlockEntityType<?>> Tiles = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ModCoreUrushi.ModID);
    public static final RegistryObject<BlockEntityType<WoodenCabinetrySlabBlockEntity>> WoodenCabinetrySlabBlockEntity=Tiles.register("wooden_cabinetry_slab", () -> BlockEntityType.Builder.of(WoodenCabinetrySlabBlockEntity::new, ItemAndBlockRegister.wooden_cabinetry_slab.get(),ItemAndBlockRegister.red_urushi_wooden_cabinetry_slab.get(),ItemAndBlockRegister.white_stained_wooden_cabinetry_slab.get(),ItemAndBlockRegister.orange_stained_wooden_cabinetry_slab.get(),ItemAndBlockRegister.magenta_stained_wooden_cabinetry_slab.get(),ItemAndBlockRegister.light_blue_stained_wooden_cabinetry_slab.get(),ItemAndBlockRegister.yellow_stained_wooden_cabinetry_slab.get(),ItemAndBlockRegister.lime_stained_wooden_cabinetry_slab.get(),ItemAndBlockRegister.pink_stained_wooden_cabinetry_slab.get(),ItemAndBlockRegister.gray_stained_wooden_cabinetry_slab.get(),ItemAndBlockRegister.light_gray_stained_wooden_cabinetry_slab.get(),ItemAndBlockRegister.cyan_stained_wooden_cabinetry_slab.get(),ItemAndBlockRegister.purple_stained_wooden_cabinetry_slab.get(),ItemAndBlockRegister.blue_stained_wooden_cabinetry_slab.get(),ItemAndBlockRegister.brown_stained_wooden_cabinetry_slab.get(),ItemAndBlockRegister.green_stained_wooden_cabinetry_slab.get(),ItemAndBlockRegister.red_stained_wooden_cabinetry_slab.get(),ItemAndBlockRegister.black_stained_wooden_cabinetry_slab.get()).build(null));
    public static final RegistryObject<BlockEntityType<WoodenCabinetryBlockEntity>> WoodenCabinetryBlockEntity=Tiles.register("wooden_cabinetry", () -> BlockEntityType.Builder.of(WoodenCabinetryBlockEntity::new, ItemAndBlockRegister.wooden_cabinetry.get(),ItemAndBlockRegister.red_urushi_wooden_cabinetry.get(),ItemAndBlockRegister.white_stained_wooden_cabinetry.get(),ItemAndBlockRegister.orange_stained_wooden_cabinetry.get(),ItemAndBlockRegister.magenta_stained_wooden_cabinetry.get(),ItemAndBlockRegister.light_blue_stained_wooden_cabinetry.get(),ItemAndBlockRegister.yellow_stained_wooden_cabinetry.get(),ItemAndBlockRegister.lime_stained_wooden_cabinetry.get(),ItemAndBlockRegister.pink_stained_wooden_cabinetry.get(),ItemAndBlockRegister.gray_stained_wooden_cabinetry.get(),ItemAndBlockRegister.light_gray_stained_wooden_cabinetry.get(),ItemAndBlockRegister.cyan_stained_wooden_cabinetry.get(),ItemAndBlockRegister.purple_stained_wooden_cabinetry.get(),ItemAndBlockRegister.blue_stained_wooden_cabinetry.get(),ItemAndBlockRegister.brown_stained_wooden_cabinetry.get(),ItemAndBlockRegister.green_stained_wooden_cabinetry.get(),ItemAndBlockRegister.red_stained_wooden_cabinetry.get(),ItemAndBlockRegister.black_stained_wooden_cabinetry.get()).build(null));
    public static final RegistryObject<BlockEntityType<DoubledWoodenCabinetryBlockEntity>> DoubledWoodenCabinetryBlockEntity=Tiles.register("doubled_wooden_cabinetry", () -> BlockEntityType.Builder.of(DoubledWoodenCabinetryBlockEntity::new, ItemAndBlockRegister.doubled_wooden_cabinetry.get(),ItemAndBlockRegister.doubled_red_urushi_wooden_cabinetry.get(),ItemAndBlockRegister.doubled_white_stained_wooden_cabinetry.get(),ItemAndBlockRegister.doubled_orange_stained_wooden_cabinetry.get(),ItemAndBlockRegister.doubled_magenta_stained_wooden_cabinetry.get(),ItemAndBlockRegister.doubled_light_blue_stained_wooden_cabinetry.get(),ItemAndBlockRegister.doubled_yellow_stained_wooden_cabinetry.get(),ItemAndBlockRegister.doubled_lime_stained_wooden_cabinetry.get(),ItemAndBlockRegister.doubled_pink_stained_wooden_cabinetry.get(),ItemAndBlockRegister.doubled_gray_stained_wooden_cabinetry.get(),ItemAndBlockRegister.doubled_light_gray_stained_wooden_cabinetry.get(),ItemAndBlockRegister.doubled_cyan_stained_wooden_cabinetry.get(),ItemAndBlockRegister.doubled_purple_stained_wooden_cabinetry.get(),ItemAndBlockRegister.doubled_blue_stained_wooden_cabinetry.get(),ItemAndBlockRegister.doubled_brown_stained_wooden_cabinetry.get(),ItemAndBlockRegister.doubled_green_stained_wooden_cabinetry.get(),ItemAndBlockRegister.doubled_red_stained_wooden_cabinetry.get(),ItemAndBlockRegister.doubled_black_stained_wooden_cabinetry.get()).build(null));
    public static final RegistryObject<BlockEntityType<RiceCauldronBlockEntity>> RiceCauldronBlockEntity=Tiles.register("rice_cauldron", () -> BlockEntityType.Builder.of(RiceCauldronBlockEntity::new, ItemAndBlockRegister.rice_cauldron.get()).build(null));
    public static final RegistryObject<BlockEntityType<FryerBlockEntity>> FryerBlockEntity=Tiles.register("fryer", () -> BlockEntityType.Builder.of(FryerBlockEntity::new, ItemAndBlockRegister.fryer.get()).build(null));
    public static final RegistryObject<BlockEntityType<FoxHopperBlockEntity>> FoxHopperBlockEntity=Tiles.register("fox_hopper", () -> BlockEntityType.Builder.of(FoxHopperBlockEntity::new, ItemAndBlockRegister.fox_hopper.get()).build(null));
    public static final RegistryObject<BlockEntityType<SenryoubakoBlockEntity>> SenryoubakoBlockEntity=Tiles.register("senryoubako", () -> BlockEntityType.Builder.of(SenryoubakoBlockEntity::new, ItemAndBlockRegister.senryoubako.get()).build(null));
    public static final RegistryObject<BlockEntityType<InvisibleButtonBlockEntity>> InvisibleButton=Tiles.register("invisible_button", () -> BlockEntityType.Builder.of(InvisibleButtonBlockEntity::new, ItemAndBlockRegister.invisible_button.get()).build(null));
    public static final RegistryObject<BlockEntityType<InvisibleLeverBlockEntity>> InvisibleLever=Tiles.register("invisible_lever", () -> BlockEntityType.Builder.of(InvisibleLeverBlockEntity::new, ItemAndBlockRegister.invisible_lever.get()).build(null));
    public static final RegistryObject<BlockEntityType<InvisiblePressurePlateBlockEntity>> InvisiblePressurePlate=Tiles.register("invisible_pressure_plate", () -> BlockEntityType.Builder.of(InvisiblePressurePlateBlockEntity::new, ItemAndBlockRegister.invisible_pressure_plate.get()).build(null));
    public static final RegistryObject<BlockEntityType<SanboBlockEntity>> Sanbo=Tiles.register("sanbo", () -> BlockEntityType.Builder.of(SanboBlockEntity::new, ItemAndBlockRegister.sanbo_tier1.get(), ItemAndBlockRegister.sanbo_tier2.get(), ItemAndBlockRegister.sanbo_tier3.get()).build(null));
    public static final RegistryObject<BlockEntityType<ShichirinBlockEntity>> Shichirin=Tiles.register("shichirin", () -> BlockEntityType.Builder.of(ShichirinBlockEntity::new, ItemAndBlockRegister.shichirin.get()).build(null));
    public static final RegistryObject<BlockEntityType<SacredRockBlockEntity>> SacredRock=Tiles.register("sacred_rock", () -> BlockEntityType.Builder.of(SacredRockBlockEntity::new, ItemAndBlockRegister.wood_element_sacred_rock.get(),ItemAndBlockRegister.fire_element_sacred_rock.get(),ItemAndBlockRegister.earth_element_sacred_rock.get(),ItemAndBlockRegister.metal_element_sacred_rock.get(),ItemAndBlockRegister.water_element_sacred_rock.get()).build(null));
    public static final RegistryObject<BlockEntityType<EmitterBlockEntity>> Emitter=Tiles.register("emitter", () -> BlockEntityType.Builder.of(EmitterBlockEntity::new, ItemAndBlockRegister.wood_element_emitter_tier1.get(),ItemAndBlockRegister.fire_element_emitter_tier1.get(),ItemAndBlockRegister.earth_element_emitter_tier1.get(),ItemAndBlockRegister.metal_element_emitter_tier1.get(),ItemAndBlockRegister.water_element_emitter_tier1.get(), ItemAndBlockRegister.wood_element_emitter_tier2.get(),ItemAndBlockRegister.fire_element_emitter_tier2.get(),ItemAndBlockRegister.earth_element_emitter_tier2.get(),ItemAndBlockRegister.metal_element_emitter_tier2.get(),ItemAndBlockRegister.water_element_emitter_tier2.get()).build(null));
    public static final RegistryObject<BlockEntityType<TankBlockEntity>> Tank=Tiles.register("tank", () -> BlockEntityType.Builder.of(TankBlockEntity::new, ItemAndBlockRegister.wood_element_tank_tier1.get(),ItemAndBlockRegister.fire_element_tank_tier1.get(),ItemAndBlockRegister.earth_element_tank_tier1.get(),ItemAndBlockRegister.metal_element_tank_tier1.get(),ItemAndBlockRegister.water_element_tank_tier1.get()).build(null));
    public static final RegistryObject<BlockEntityType<MirrorBlockEntity>> Mirror=Tiles.register("mirror", () -> BlockEntityType.Builder.of(MirrorBlockEntity::new, ItemAndBlockRegister.mirror_tier1.get()).build(null));
    public static final RegistryObject<BlockEntityType<ElementCraftingTableBlockEntity>> ElementCraftingTable=Tiles.register("element_crafting_table", () -> BlockEntityType.Builder.of(ElementCraftingTableBlockEntity::new, ItemAndBlockRegister.wood_element_crafting_table_tier1.get(),ItemAndBlockRegister.fire_element_crafting_table_tier1.get(),ItemAndBlockRegister.earth_element_crafting_table_tier1.get(),ItemAndBlockRegister.metal_element_crafting_table_tier1.get(),ItemAndBlockRegister.water_element_crafting_table_tier1.get()).build(null));
    public static final RegistryObject<BlockEntityType<HokoraBlockEntity>> Hokora=Tiles.register("hokora", () -> BlockEntityType.Builder.of(HokoraBlockEntity::new, ItemAndBlockRegister.wood_element_hokora.get(),ItemAndBlockRegister.fire_element_hokora.get(),ItemAndBlockRegister.earth_element_hokora.get(),ItemAndBlockRegister.metal_element_hokora.get(),ItemAndBlockRegister.water_element_hokora.get()).build(null));
    public static void register(IEventBus eventBus) {
        Tiles.register(eventBus);
    }
}
