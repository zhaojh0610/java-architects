package com.zjh.shardingjdbcdemo.sharding;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @author zhaojh
 */
public class MySharding implements PreciseShardingAlgorithm<String> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        String id = shardingValue.getValue();

        int mode = id.hashCode() % availableTargetNames.size();
        String[] strings = availableTargetNames.toArray(new String[0]);
        mode = Math.abs(mode);

        System.out.println(strings[0] + "---------" + strings[1]);
        System.out.println("mode=" + mode);
        return strings[mode];
    }
}
