package org.dedda.games.scheisse.service.transport;

import org.dedda.games.scheisse.entity.*;
import org.dedda.games.scheisse.entity.item.Item;

/**
 * Created by dedda on 3/12/15.
 */
public abstract class EntityContainer {

    private final EntityType type;
    private final Entity entity;

    public EntityContainer(final EntityType type, final Entity entity) {
        this.type = type;
        this.entity = entity;
    }

    public EntityType getType() {
        return type;
    }

    public Entity getEntity() {
        return entity;
    }

    public class EntityContainerBuilder {

        private Entity entity;

        public void setEntity(final Entity entity) {
            this.entity = entity;
        }

        public EntityContainer build() {
            if (entity instanceof User) {
                return new UserContainer((User)entity);
            }
            if (entity instanceof Item) {
                return new ItemContainer((Item)entity);
            }
            if (entity instanceof Slot) {
                return new SlotContainer((Slot)entity);
            }
            if (entity instanceof Inventory) {
                return new InventoryContainer((Inventory)entity);
            }
            if (entity instanceof ShopRequest) {
                return new ShopRequestContainer((ShopRequest)entity);
            }
            throw new IllegalArgumentException("entity not supported");
        }
    }

}
