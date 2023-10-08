package codyhuh.ravagecabbage.client.render;

import codyhuh.ravagecabbage.client.model.RCRavagerModel;
import codyhuh.ravagecabbage.client.render.layer.RCRavagerBannerLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SaddleLayer;
import net.minecraft.resources.ResourceLocation;
import codyhuh.ravagecabbage.RavageAndCabbage;
import codyhuh.ravagecabbage.client.ClientEvents;
import codyhuh.ravagecabbage.client.render.layer.RCRavagerHornLayer;
import codyhuh.ravagecabbage.common.entities.RCRavagerEntity;

public class RCRavagerRenderer extends MobRenderer<RCRavagerEntity, RCRavagerModel> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(RavageAndCabbage.MOD_ID, "textures/entity/tamed_ravager.png");
	private static final ResourceLocation SADDLE_TEXTURE = new ResourceLocation(RavageAndCabbage.MOD_ID, "textures/entity/ravager_equipment/saddle.png");
    private static final ResourceLocation BABY_TEXTURE = new ResourceLocation(RavageAndCabbage.MOD_ID, "textures/entity/ravager_baby.png");

	public RCRavagerRenderer(EntityRendererProvider.Context context) {
		super(context, new RCRavagerModel(context.bakeLayer(ClientEvents.RAVAGER)), 1.1F);
		this.addLayer(new SaddleLayer<>(this, new RCRavagerModel(context.bakeLayer(ClientEvents.RAVAGER_SADDLE)), SADDLE_TEXTURE));
		//this.addLayer(new RCRavagerBannerLayer(this));
		this.addLayer(new RCRavagerHornLayer<>(this, new RCRavagerModel(context.bakeLayer(ClientEvents.RAVAGER_HORNS))));
	}

	@Override
	public ResourceLocation getTextureLocation(RCRavagerEntity entity) {
		 if (entity.isBaby()) {
	            return BABY_TEXTURE;
	        }
	        else {
	        	return TEXTURE;
	        }
	}

}