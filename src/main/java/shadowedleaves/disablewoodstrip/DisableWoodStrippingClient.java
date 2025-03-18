package shadowedleaves.disablewoodstrip;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class DisableWoodStrippingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (world.isClient) {
                ItemStack itemStack = player.getStackInHand(hand);
                if (itemStack.getItem() instanceof AxeItem) {
                    BlockPos pos = hitResult.getBlockPos();
                    Block block = world.getBlockState(pos).getBlock();
                    if (isStrippableWood(block)) {
                        return ActionResult.FAIL;
                    }
                }
            }
            return ActionResult.PASS;
        });
    }

    private boolean isStrippableWood(Block block) {
        return block == Blocks.OAK_LOG || block == Blocks.SPRUCE_LOG || block == Blocks.BIRCH_LOG ||
                block == Blocks.JUNGLE_LOG || block == Blocks.ACACIA_LOG || block == Blocks.DARK_OAK_LOG ||
                block == Blocks.MANGROVE_LOG || block == Blocks.OAK_WOOD || block == Blocks.SPRUCE_WOOD ||
                block == Blocks.BIRCH_WOOD || block == Blocks.JUNGLE_WOOD || block == Blocks.ACACIA_WOOD ||
                block == Blocks.DARK_OAK_WOOD || block == Blocks.MANGROVE_WOOD ||
                block == Blocks.CRIMSON_STEM || block == Blocks.WARPED_STEM;
    }
}