package me.perzan.fabric.lowfire;

import net.minecraft.util.math.Vec3d;

public class LowfireConfig {
    Vec3d translate;

    LowfireConfig(Vec3d translate) {
        this.translate = translate;
    }

    public Vec3d getTanslate() {
        return translate;
    }
}
