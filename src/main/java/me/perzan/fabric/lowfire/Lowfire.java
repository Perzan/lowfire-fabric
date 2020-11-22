package me.perzan.fabric.lowfire;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

public class Lowfire implements ClientModInitializer {

    static final Gson GSON = new Gson();

    static LowfireConfig config = new LowfireConfig(new Vec3d(0, -0.3, 0));

    public static LowfireConfig getLowfireConfig() {
        return config;
    }

    @Override
    public void onInitializeClient() {
        Path configPath = FabricLoader.getInstance().getConfigDir().resolve("lowfire.json");

        if (Files.isReadable(configPath) && !Files.isDirectory(configPath)) {
            LowfireConfig config;

            try (Reader reader = new InputStreamReader(Files.newInputStream(configPath))) {
                config = GSON.fromJson(reader, LowfireConfig.class);
            } catch (IOException ioe) {
                ioe.printStackTrace();
                return;
            } catch (JsonParseException jpe) {
                MinecraftClient client = MinecraftClient.getInstance();

                if (client == null || client.player == null) jpe.printStackTrace();
                else client.player.sendMessage(Text.of("[Lowfire] Cannot parse config: " + jpe.getMessage()), false);
                return;
            }

            Vec3d translate = config.getTanslate();

            if (translate == null) return;

            config = new LowfireConfig(translate);
        }
    }
    
}
