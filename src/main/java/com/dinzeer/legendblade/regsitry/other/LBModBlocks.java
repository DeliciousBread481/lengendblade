package com.dinzeer.legendblade.regsitry.other;

import com.dinzeer.legendblade.Block.WonderReactor;
import com.dinzeer.legendblade.regsitry.creativetab.ItemTab;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import mods.flammpfeil.slashblade.init.SBItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.common.Tags;

import static com.dinzeer.legendblade.Legendblade.REGISTRATE;

public class LBModBlocks {


    public static final RegistryEntry<WonderReactor> wonder_reactor = REGISTRATE.block("wonder_reactor",
            p-> new WonderReactor()  ).tag(

            BlockTags.MINEABLE_WITH_PICKAXE,BlockTags.NEEDS_DIAMOND_TOOL
    ).defaultBlockstate().defaultLang().item().build().register();

    public static final BlockEntry<RotatedPillarBlock> proud_soul_log=
            REGISTRATE.block("proud_soul_log", RotatedPillarBlock::new)
                    .properties(p -> p.strength(2.0F))
                    .tag(BlockTags.MINEABLE_WITH_AXE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.LOGS)
                    .blockstate((ctx, prov) -> prov.logBlock(ctx.getEntry()))
                    .defaultLang()
                    .item()
                    .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), "minecraft:block/cube_column")
                            .texture("side", prov.modLoc("block/proud_soul_log"))
                            .texture("end", prov.modLoc("block/proud_soul_log_side")))
                    .tab(ItemTab.LBITEM.getKey())
                    .build().register();

//    public static final BlockEntry<LeavesBlock> proud_soul_leaves=
//            REGISTRATE.block("proud_soul_leaves", LeavesBlock::new)
//                    .properties(p -> p.strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()
//                    )
//                    .tag(BlockTags.LEAVES)
//                    .defaultBlockstate().defaultLang()
//                    .item()
//                    .model((ctx, prov) ->
//                            prov.withExistingParent(ctx.getName(),
//                                    prov.modLoc("block/proud_soul_leaves")))
//                    .tab(ItemTab.LBITEM.getKey())
//                    .build().register();



    public static final BlockEntry<SaplingBlock> proud_soul_sampling=
            REGISTRATE
                    .block("proud_soul_sampling", p -> new SaplingBlock(new ProudSoulTreeGrower(), p))
                    .properties(p -> p.strength(0.0F).noCollission().sound(SoundType.GRASS))
                    .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(), prov.models().cross(
                            ctx.getName(), prov.modLoc("block/proud_soul_sampling"))

                    ))
                    .defaultLang()
                    .item()
                    .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), "minecraft:item/generated")
                            .texture("layer0", prov.modLoc("item/" + ctx.getName()))
                    )
                    .tab(ItemTab.LBITEM.getKey())
                    .build().register();




    public static final BlockEntry<LeavesBlock> proud_soul_leaves=
            REGISTRATE
                    .block("proud_soul_leaves", LeavesBlock::new)
                    .properties(p -> p.strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion())
                    .tag(BlockTags.LEAVES)
                    .defaultBlockstate().defaultLang()
                    .loot((table, block) -> {
                        table.add(block, LootTable.lootTable()
                                .withPool(LootPool.lootPool()
                                        .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS)))
                                        .add(LootItem.lootTableItem(block)))
                                .withPool(LootPool.lootPool()
                                        .add(LootItem.lootTableItem(proud_soul_sampling.get())
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1)))
                                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
                                                .when(LootItemRandomChanceCondition.randomChance(0.01F))))// 1% 概率
                                        );


                        ;
                    })
                    .item()
                    .tab(ItemTab.LBITEM.getKey())
                    .build()
                    .register();

    public static final BlockEntry<Block> proud_soul_ore= REGISTRATE
            .block("proud_soul_ore", Block::new)
            .properties(p -> p.strength(3.0F, 3.0F) // 设置硬度和爆炸抗性
                    .requiresCorrectToolForDrops())
            .tag( BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.LOGS,BlockTags.NEEDS_IRON_TOOL)
            .blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models().cubeAll(
                            ctx.getName(), prov.modLoc("block/" + ctx.getName())
                    )))
            .loot((table, block) -> table.add(block, LootTable.lootTable()
                    .withPool(LootPool.lootPool()
                            .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(Tags.Items.TOOLS)))
                            .add(LootItem.lootTableItem(SBItems.proudsoul_tiny))
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                    )))

            .item()
                    .tab(ItemTab.LBITEM.getKey()) // 添加到自定义创造模式标签页
                    .build()
            .register();

    public static final BlockEntry<Block> deep_proud_soul_ore= REGISTRATE
            .block("deep_proud_soul_ore", Block::new)
            .properties(p -> p.strength(5.0F, 7.0F) // 设置硬度和爆炸抗性
                    .requiresCorrectToolForDrops())
            .tag( BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.LOGS,BlockTags.NEEDS_IRON_TOOL) // 需要铁镐或更高级的工具
            .blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(), prov.models().cubeAll(
                    ctx.getName(), prov.modLoc("block/" + ctx.getName())
            )))
            .loot((table, block) -> {
                table.add(block, LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(Tags.Items.TOOLS)))
                                .add(LootItem.lootTableItem(SBItems.proudsoul_tiny)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4)))))); // 掉落 1-2 个 proud_soul_tiny
            })

            .item()
            .tab(ItemTab.LBITEM.getKey()) // 添加到自定义创造模式标签页
            .build()
            .register();



    public static void register(){

    }

}
