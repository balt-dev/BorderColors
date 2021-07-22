package net.bordercolors;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.text.TranslatableText;

public class ModMenuIntegration implements ModMenuApi {
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            ConfigBuilder builder = ConfigBuilder.create()
                    .setParentScreen(parent)
                    .setTitle(new TranslatableText("title.bordercolors.config"));
            ConfigCategory general = builder.getOrCreateCategory(new TranslatableText("category.bordercolors.general"));
            ConfigEntryBuilder entryBuilder = builder.entryBuilder();
            general.addEntry(entryBuilder.startColorField(new TranslatableText("option.bordercolors.stationary"), BorderColors.stationaryColor)
                    .setDefaultValue(2138367)
                    .setSaveConsumer(newValueStationary -> BorderColors.stationaryColor = newValueStationary)
                    .requireRestart()
                    .build())
            .addEntry(entryBuilder.startColorField(new TranslatableText("option.bordercolors.shrinking"), BorderColors.shrinkingColor)
                    .setDefaultValue(16724016)
                    .setSaveConsumer(newValueShrinking -> BorderColors.shrinkingColor = newValueShrinking)
                    .requireRestart()
                    .build())
            .addEntry(entryBuilder.startColorField(new TranslatableText("option.bordercolors.growing"), BorderColors.growingColor)
                    .setDefaultValue(4259712)
                    .setSaveConsumer(newValueGrowing -> BorderColors.growingColor = newValueGrowing)
                    .requireRestart()
                    .build());
            builder.setSavingRunnable(() -> {
                try {
                    BorderColors.saveConfig(BorderColors.configFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                BorderColors.loadConfig(BorderColors.configFile);
            });
            return builder.build();
        };
    }
}
