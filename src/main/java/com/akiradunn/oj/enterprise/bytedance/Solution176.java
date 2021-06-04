package com.akiradunn.oj.enterprise.bytedance;
//176. 第二高的薪水
//SQL架构
//编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。
//
//+----+--------+
//| Id | Salary |
//+----+--------+
//| 1  | 100    |
//| 2  | 200    |
//| 3  | 300    |
//+----+--------+
//例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。
//
//+---------------------+
//| SecondHighestSalary |
//+---------------------+
//| 200                 |
//+---------------------+
//通过次数214,888提交次数603,978
public class Solution176 {
    //select IFNULL((select DISTINCT Salary from employee order by Salary desc limit 1 offset 1), null) as SecondHighestSalary;
}
