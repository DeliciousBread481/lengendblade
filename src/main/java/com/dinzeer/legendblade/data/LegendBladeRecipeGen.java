package com.dinzeer.legendblade.data;

import com.dinzeer.legendblade.regsitry.other.LBModBlocks;
import com.dinzeer.legendblade.regsitry.other.LBModItems;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.DataIngredient;
import mods.flammpfeil.slashblade.init.SBItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.BiFunction;

public class LegendBladeRecipeGen {
    public static void onRecipeGen(RegistrateRecipeProvider pvd) {
        unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.MISC, LBModItems.saligiaex, 1)::unlockedBy, Items.IRON_INGOT)
                .pattern("ABC")
                .pattern(" D ")
                .pattern("EFG")
                .define('A', LBModItems.acedia)
                .define('B',LBModItems.avaritia)
                .define('C',LBModItems.gula)
                .define('D', LBModItems.ira)
                .define('E', LBModItems.invidia)
                .define('F',LBModItems.superbia)
                .define('G', LBModItems.luxuria)
                .save(pvd);

        unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                LBModItems.icegem, 1)::unlockedBy, Items.IRON_INGOT)
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', SBItems.proudsoul)
                .define('B', Items.ICE)
                .save(pvd);
        unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                LBModItems.dragon_gem, 1)::unlockedBy, Items.IRON_INGOT)
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', SBItems.proudsoul)
                .define('B', Items.REDSTONE_BLOCK)
                .save(pvd);
        unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                LBModItems.water_gem, 1)::unlockedBy, Items.IRON_INGOT)
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', SBItems.proudsoul)
                .define('B', Items.WATER_BUCKET)
                .save(pvd);
        unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                LBModBlocks.wonder_reactor.get(), 1)::unlockedBy, Items.IRON_INGOT)
                .pattern("AAA")
                .pattern("BCB")
                .pattern("AAA")
                .define('A', SBItems.proudsoul_ingot)
                .define('B', Items.LAPIS_BLOCK)
                .define('C', Items.CLOCK)
                .save(pvd);
        unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                Items.DRAGON_EGG, 1)::unlockedBy, Items.IRON_INGOT)
                .pattern("ACA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.DIAMOND)
                .define('B', Items.DRAGON_HEAD)
                .define('C', Items.NETHER_STAR)
                .save(pvd);
        unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                LBModItems.god_soul_crystal, 1)::unlockedBy, Items.IRON_INGOT)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', LBModItems.soul_crystal)
                .save(pvd);
        unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                LBModItems.godex, 1)::unlockedBy, Items.IRON_INGOT)
                .pattern("BAB")
                .pattern("AAA")
                .pattern("BAB")
                .define('A', LBModItems.god)
                .define('B',Items.POTION)
                .save(pvd);




    }

    public static <T> T unlock(RegistrateRecipeProvider pvd, BiFunction<String, InventoryChangeTrigger.TriggerInstance, T> func, Item item) {
        return func.apply("has_" + pvd.safeName(item), DataIngredient.items(item).getCritereon(pvd));
    }
}
