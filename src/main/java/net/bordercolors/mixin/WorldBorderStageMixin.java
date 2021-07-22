package net.bordercolors.mixin;

import net.bordercolors.BorderColors;
import net.minecraft.world.border.WorldBorderStage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

/** @noinspection UnresolvedMixinReference*/
@Mixin(WorldBorderStage.class)
public class WorldBorderStageMixin {
	@ModifyConstant(method = "<clinit>", constant = @Constant(intValue = 2138367))
	private static int newStationary(int _n){
		return BorderColors.stationaryColor;
	}
	@ModifyConstant(method = "<clinit>", constant = @Constant(intValue = 4259712))
	private static int newGrowing(int _n){
		return BorderColors.growingColor;
	}
	@ModifyConstant(method = "<clinit>", constant = @Constant(intValue = 16724016))
	private static int newShrinking(int _n){
		return BorderColors.shrinkingColor;
	}
}


