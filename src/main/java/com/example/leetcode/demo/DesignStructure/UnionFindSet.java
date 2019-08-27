package com.example.leetcode.demo.DesignStructure;

import java.util.HashMap;
import java.util.List;

/**
 * Copyright (c) 2019 maoyan.com
 * All rights reserved.
 *
 * @author liying84
 * @created 2019-07-09
 * @descript 并查集
 */
public class UnionFindSet {



    public static class Node {
        // 自己定义
    }

    public static HashMap<Node, Node> fatherMap; // key : child  value : father
    public static HashMap<Node, Integer> sizeMap; // key : node  value : 所在集合 有多少节点

    public UnionFindSet(List<Node> nodes) {
        makeSets(nodes);
    }

    private void makeSets(List<Node> nodes) {
        fatherMap = new HashMap<Node, Node>();
        sizeMap = new HashMap<Node, Integer>();
        for (Node node : nodes) {
            fatherMap.put(node, node);
            sizeMap.put(node, 1);
        }
    }

    private Node findHead(Node node) {
        Node father = fatherMap.get(node);
        if (father != node) {
            father = findHead(father);
        }
        // 找到把该节点连接到父节点
        fatherMap.put(node, father);
        return father;
    }

    /**
     * 判断是不是同一个set 只需要判断father 是否是同一个
     */
    public boolean isSameSet(Node e, Node k) {
        return findHead(e) == findHead(k);
    }

    public void union(Node e, Node k) {
        if (e == null || k == null) {
            return;
        }

        Node eHead = findHead(e);
        Node kHead = findHead(k);
    }
}
