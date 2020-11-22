package me.perzan.fabric.lowfire.util;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.perzan.fabric.lowfire.Lowfire;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;

public class FireRenderTranslator {

    public static void onRenderFire(MinecraftClient client, MatrixStack stack, CallbackInfo ci) {
        Vec3d translate = Lowfire.getLowfireConfig().getTanslate();

        {
            stack.push();
            stack.translate(translate.x, translate.y, translate.z);
        }
    }

    public static void onRenderFireReturn(MinecraftClient client, MatrixStack stack, CallbackInfo ci) {
        stack.pop();
    }
    
}
