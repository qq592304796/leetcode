package org.data_structure.tree.binary_search_tree;

import java.util.Random;

/**
 * 二叉搜索树
 * @author 爱学习的程序员
 * @version V1.0
 */
public class BST{
    // 根结点
    public static Node root = null;
    /**
     * 二叉搜索树的结点类
     */
    public static class Node{
        // 父结点
        Node p;
        // 左孩子
        Node left;
        // 右孩子
        Node right;
        // 关键字
        int key;
        public Node(Node p, Node left, Node right, int key){
            this.p = p;
            this.left = left;
            this.right = right;
            this.key = key;
        }
    }

    /**
     * 插入结点
     * @param z 待插入结点
     * @return 根结点
     */
    public static void insert(Node z){
        // 树为空，直接作为根结点
        if(root == null)
            root = z;
        else{
            Node y = null;
            Node x = root;
            // 寻求树中结点z的合适位置
            while(x != null){
                y = x;
                if(z.key < x.key)
                    x = x.left;
                else
                    x = x.right;
            }
            z.p = y;
            if(z.key < y.key)
                y.left = z;
            else
                y.right = z;
        }
    }

    /**
     * 中序遍历二叉搜索树
     * @param x 树中结点
     * @return 无
     */
    public static void inorderTreeWalk(Node x){
        if(x!=null){
            inorderTreeWalk(x.left);
            System.out.print(x.key+"\t");
            inorderTreeWalk(x.right);
        }
    }

    /**
     * 二叉搜索树中查找一个具有指定关键字的结点
     * @param x 树中结点
     * @param k 关键字
     * @return 无
     */
    public static Node search(Node x, int k){
       while(x != null && x.key != k){
           if(k < x.key)
                x = x.left;
            else
                x = x.right;
       }
       return x;
    }

    /**
     * 二叉搜索树中关键字最小的结点
     * @param x 树中结点
     * @return 关键字最小的结点
     */
    public static Node minimum(Node x){
        while(x.left != null)
            x = x.left;
        return x;
    }

    /**
     * 二叉搜索树中关键字最大的结点
     * @param x 树中结点
     * @return 关键字最大的结点
     */
    public static Node maxmum(Node x){
        while(x.right != null)
            x = x.right;
        return x;
    }


    /**
     * 结点的后继（中序遍历）
     * @param x 树中结点
     * @return 结点的后继
     */
    public static Node successor(Node x){
        // 如果x的右子树不为空，则x的后继为x的右子树中具有最小关键字的结点
        if(x.right != null)
            return minimum(x.right);
        // 如果x的右子树为空，则x的后继为x的最底层祖先，而且它的左孩子也是x的一个祖先（左孩子是x即可）
        else{
            Node y = x.p;
            while(y !=null && x == y.right){
                x = y;
                y = y.p;
            }
            return y;
        }
    }

    /**
     * 结点的先驱（代码与结点的后继对称）
     * @param x 树中结点
     * @return 结点的先驱
     */
    public static Node predecessor(Node x){
        if(x.left != null)
            return maxmum(x.left);
        else{
            Node y = x.p;
            while(y !=null && x == y.left){
                x = y;
                y = y.p;
            }
            return y;
        }
    }

    /**
     * 二叉搜索树内移动子树（用另一棵子树替换一棵子树，并成为其父结点的孩子结点）
     * @param u 被替换子树的根结点
     * @param v 替换子树的根结点
     * @return 无
     */
    public static void transplant(Node u, Node v){
        if(u.p == null)
            root = v;
        else if(u == u.p.left)
            u.p.left = v;
        else
            u.p.right = v;
        if(v != null)
            v.p = u.p;
    }

    /**
     * 删除指定结点
     * @param z 待删除结点
     * @return 无
     */
    public static void delete(Node z){
        // 如果z最多有一个孩子结点，则直接调用transplant
        if(z.left == null)
            transplant(z, z.right);
        else if(z.right == null)
            transplant(z, z.left);
        // 如果z两个孩子结点都存在，则寻找其后继
        else{
            // z的后继
            Node y = minimum(z.right);
            if(y.p != z){
                transplant(z, z.right);
                y.right = z.right;
                y.right.p = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.p = y;
        }
    }
    public static void main(String[] args){
        Random rand = new Random();
        // 结点数组
        Node[] node = new Node[10];
        int i = 0;
        System.out.println("生成二叉树结点并插入树中：");
        for(i = 0; i < node.length ;i++){
            node[i] = new Node(null, null, null, rand.nextInt(100) + 1);
            System.out.print(node[i].key+"\t");
            insert(node[i]);
        }
        // 中序遍历
        System.out.println("\n"+"中序遍历二叉搜索树：");
        inorderTreeWalk(root);
        // 查找指定结点
        Node x = search(root, node[5].key);
        System.out.println("\n"+"查找结果：");
        System.out.println("自身关键字："+x.key+"\t"+"父结点的关键字："+x.p.key);
        // 具有最小关键字的结点
        x = minimum(root);
        System.out.println("树中最小关键字："+x.key);
        // 具有最大关键字的结点
        x = maxmum(root);
        System.out.println("树中最大关键字："+x.key);
        // x的后继
        x = predecessor(node[5]);
        System.out.println("前驱的关键字："+x.key);
        // x的前驱
        x = successor(node[5]);
        System.out.println("后继的关键字："+x.key);
        // 删除结点，并中序输出观看结果
        delete(node[5]);
        System.out.println("删除结点：");
        inorderTreeWalk(root);
    }
}
