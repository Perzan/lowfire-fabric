package me.perzan.fabric.lowfire.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.perzan.fabric.lowfire.util.FireRenderTranslator;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameOverlayRenderer;
import net.minecraft.client.util.math.MatrixStack;

@Mixin(InGameOverlayRenderer.class)
class FireRenderMixin {

    @Inject(at = @At("HEAD"), method = "renderFireOverlay")
    private static void renderFireOverlay(MinecraftClient client, MatrixStack stack, CallbackInfo ci) {
        FireRenderTranslator.onRenderFire(client, stack, ci);
    }

    @Inject(at = @At("RETURN"), method = "renderFireOverlay")
    private static void renderFireOverlayReturn(MinecraftClient client, MatrixStack stack, CallbackInfo ci) {
        FireRenderTranslator.onRenderFireReturn(client, stack, ci);
    }

}
