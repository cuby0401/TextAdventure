package GameMap;

import java.util.Map;

public class Block {
    private Map<Direction, Block> neighbouringBlocks;
    private BlockType blockType;
    private boolean isAvailable;

    public Map<Direction, Block> getNeighbouringBlocks() {
        return neighbouringBlocks;
    }

    public Block setNeighbouringBlocks(Map<Direction, Block> neighbouringBlocks) {
        this.neighbouringBlocks = neighbouringBlocks;
        return this;
    }

    public Block(BlockType blockType, boolean isAvailable) {
        this.blockType = blockType;
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Block setAvailable(boolean available) {
        isAvailable = available;
        return this;
    }

    public BlockType getBlockType() {
        return blockType;
    }

    public Block setBlockType(BlockType blockType) {
        this.blockType = blockType;
        return this;
    }
}
