package com.learn.entity;

import lombok.Data;

/**
 * 创建人：江文谱
 * 创建时间： 2020/5/1 14:57
 * 版本： 1.0
 */
@Data
public class SalaryLevelEntity {

    private Integer oneLevel;
    private Integer twoLevel;
    private Integer threeLevel;
    private Integer fourLevel;
    private Integer fiveLevel;
    private Integer sixLevel;
    private Integer sevenLevel;
    private Integer eightLevel;
    private Integer nineLevel;
//    private Map<String, Object> eChart;

//    private List<String> keys;
//    private List<Integer> values;
//
//    public Map<String, Object> geteChart() {
//        this.eChart = new HashMap<>();
//        eChart.put("categories", keys);
//        eChart.put("data", values);
//        return eChart;
//    }
}
