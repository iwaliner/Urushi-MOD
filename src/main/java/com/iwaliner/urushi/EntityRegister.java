package com.iwaliner.urushi;

import com.iwaliner.urushi.entiity.food.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityRegister {public static final DeferredRegister<EntityType<?>> Entities = DeferredRegister.create(ForgeRegistries.ENTITIES, ModCoreUrushi.ModID);
    public static final RegistryObject<EntityType<RiceFoodEntity>> RiceFoodEntity=Entities.register("rice_food", () -> EntityType.Builder.<RiceFoodEntity>of(RiceFoodEntity::new, MobCategory.MISC).sized(0.4F, 0.4F).clientTrackingRange(8).build(new ResourceLocation(ModCoreUrushi.ModID,"rice_food").toString()));
    public static final RegistryObject<EntityType<com.iwaliner.urushi.entiity.food.TKGFoodEntity>> TKGFoodEntity=Entities.register("tkg_food", () -> EntityType.Builder.<TKGFoodEntity>of(TKGFoodEntity::new, MobCategory.MISC).sized(0.4F, 0.4F).clientTrackingRange(8).build(new ResourceLocation(ModCoreUrushi.ModID,"tkg_food").toString()));
    public static final RegistryObject<EntityType<SekihanFoodEntity>> SekihanFoodEntity=Entities.register("sekihan_food", () -> EntityType.Builder.<SekihanFoodEntity>of(SekihanFoodEntity::new, MobCategory.MISC).sized(0.4F, 0.4F).clientTrackingRange(8).build(new ResourceLocation(ModCoreUrushi.ModID,"sekihan_food").toString()));
    public static final RegistryObject<EntityType<GyudonFoodEntity>> GyudonFoodEntity=Entities.register("gyudon_food", () -> EntityType.Builder.<GyudonFoodEntity>of(GyudonFoodEntity::new, MobCategory.MISC).sized(0.4F, 0.4F).clientTrackingRange(8).build(new ResourceLocation(ModCoreUrushi.ModID,"gyudon_food").toString()));
    public static final RegistryObject<EntityType<ButadonFoodEntity>> ButadonFoodEntity=Entities.register("butadon_food", () -> EntityType.Builder.<ButadonFoodEntity>of(ButadonFoodEntity::new, MobCategory.MISC).sized(0.4F, 0.4F).clientTrackingRange(8).build(new ResourceLocation(ModCoreUrushi.ModID,"butadon_food").toString()));

    public static void register(IEventBus eventBus) {
        Entities.register(eventBus);
    }

}