package io.github.shibadog.ragdoll.entity;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import io.github.shibadog.ragdoll.exception.ApplicationException;
import io.github.shibadog.ragdoll.util.Util;
import lombok.Data;

@Data
public class Chain {
    private List<Block> chain = new ArrayList<Block>();

    public Chain() throws ApplicationException {
        this.chain.add(getGenesisBlock());
    }

    private Block getGenesisBlock() throws ApplicationException {
        long index = 0L;
        long generateTime = LocalDateTime.now().toInstant(ZoneOffset.ofHours(9)).toEpochMilli();
        String previousHash = "0";
        String data = "my genesis block!!";
        String hash = Util.generateHash(index, previousHash, generateTime, data);
        return new Block(index, generateTime, previousHash, data, hash); 
    }

    public Chain generateNextBlock(String blockData) throws ApplicationException {
        Block lastBlock = this.chain.get(this.chain.size() - 1);
        long nextIndex = lastBlock.getIndex() + 1L;
        long nextGenerateTime = LocalDateTime.now().toInstant(ZoneOffset.ofHours(9)).toEpochMilli();
        String previousHash = lastBlock.getHash();
        String hash = Util.generateHash(nextIndex, previousHash, nextGenerateTime, blockData);
        Block block = new Block(nextIndex, nextGenerateTime, previousHash, blockData, hash);
        this.chain.add(block);
        return this;
    }
}