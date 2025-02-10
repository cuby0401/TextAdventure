package GameMap;

public class BlockFabric {
    public Block createBlock(BlockType blockType, boolean isAvailable) {
        return new Block(blockType, isAvailable);
    }
}