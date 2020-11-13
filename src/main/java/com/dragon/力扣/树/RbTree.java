package com.dragon.力扣.树;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 红黑树
 * @param <k>
 * @param <v>
 */
public class RbTree<k extends Comparable<k>,v> {

    private static final boolean RED = true;
    private static final boolean BLACK = true;

    //定义树根
    private RBNode root;
    /**
     * 获取当前节点的父节点
     * @param node
     */
    private RBNode parentOf(RBNode node){
        if(node!=null){
            return node.parent;
        }
        return null;
    }

    /**
     * 判断节点是不是红色
     * @param node
     * @return
     */
    private boolean isRed(RBNode node){
        if(node!=null){
            return node.color==RED;
        }
        return false;
    }

    /**
     * 判断节点是不是黑色
     * @param node
     * @return
     */
    private boolean isBlack(RBNode node){
        if(node!=null){
            return node.color==BLACK;
        }
        return false;
    }

    /**
     * 设置节点位红色
     * @param node
     */
    private void setRed(RBNode node){
        if(node!=null){
            node.color=RED;
        }
    }

    /**
     * 设置节点位黑色
     * @param node
     */
    private void setBlack(RBNode node){
        if(node!=null){
            node.color=BLACK;
        }
    }


    /**
     * 中序打印红黑树
     *
     */
    public void inOrderPrint(){
        inOrderPrint(this.root);
    }
    /**
     * 中序打印红黑树
     * @param node
     */
    private void inOrderPrint(RBNode node) {
        if(node!=null){
            inOrderPrint(node.left);
            System.out.println("key"+node.key+"value"+node.value);
            inOrderPrint(node.right);
        }

    }

    /**
     * 左旋
     *      P                       P
     *      |                       |
     *      X                       Y
     *    /  \          ---->      / \
     *   lx   y                   x   l
     *       / \                 / \
     *      ly  l              lx  ly
     *
     *   1.y的左子节点的父节点更新为x，并将x的右子节点指向y的左节点
     *   2。当x父节点不为空时，更新y的父节点为x的父节点，并将x的父节点指定 子树（当前x的子树的位置）指定为y
     *   3.将x的父节点更新为y，将y的左子节点更新为x
     */
    private void leftRotate(RBNode x){
        RBNode y = x.right;     //保存x的右节点，因为x的右节点要新曾节点了
        //1.y的左节点-->x的右节点
        x.right = y.left;
        if(y.left!=null){
            y.left.parent = x;
        }
        //2.x父节点不为空时，更新y的父节点为x的父节点
        if(x.parent != null){
            y.parent = x.parent;
            //3.如果x在父节点的左边，y就放在x父节点的左边（右边同理）
            if(x == x.parent.left){
                x.parent.left = y;
            }else{
                x.parent.right = y;
            }
        }else{//如果x时根节点，则将y更新为根节点
            this.root = y;
        }
        //3.将x的父节点更新为y，将y的左子节点更新为x
        x.parent = y;
        y.left = x;
    }

    /**
     * 右旋
     *            p                       P
     *            |                       |
     *            y                       x
     *          /  \        <------      / \
     *         lx   x                   y   l
     *             / \                 / \
     *            ly  l              lx  ly
     * @param x
     */
    private void rightRotate(RBNode x) {
        //1.
        RBNode y = x.left;
        x.left = y.right;
        if(y.right!=null){
            y.right.parent = x;
        }
        //2.
        if(x.parent != null){
            y.parent = x.parent;
            if(x==x.parent.left){
              x.parent.left = y;
            }else{
              x.parent.right = y;
            }
        }else {
            this.root = y;
        }

        //3.
        x.parent = y;
        y.right = x;
    }

    public void insert(k key,v value){
        RBNode node = new RBNode();
        node.setKey(key);
        node.setValue(value);
        //新的节点一定时红色
        node.setColor(RED);
        insert(node);
    }

    /**
     * 从根节点开始查找给定节点的父节点
     * @param node
     */
    private void insert(RBNode node){
        //1.查找node的父节点parent
        RBNode parent = null;
        RBNode x = this.root;

        while(x!=null){
            parent = x;
            //>0   去x右子树查找
            // ==0 key相等需要替换
            //< 0  去x左子树查找
            int cmp = node.key.compareTo(x.key);
            if(cmp>0){
                x = x.right;
            }else if(cmp == 0){
                x.setValue(node.getValue());
                break;
            }else{
                x = x.left;
            }
        }
        //连接node和找到的父节点
        node.parent = parent;
        //判断node与parent的节点大小
        if(parent!=null){
            int cmp = node.key.compareTo(parent.key);
            if(cmp>0){
                parent.right = node;
            }else {
                parent.left = node;
            }
        }else{
            this.root = node;
        }

        //修复红黑树的平衡
        insertFixUp(node);
    }

    private void insert01(RBNode node) {
        RBNode parent = null;
        RBNode root = this.root;
        while(root!=null){
            parent = root;
            int x = node.key.compareTo(root.key);
            //右节点
            if(x>0){
                root = root.right;
            }else if(x==0){
                root.setKey(node.getKey());
            }else{
                root = root.left;
            }
    }
        //连接node和parent
        node.parent = parent;
        if(parent!=null){
            int x = node.key.compareTo(parent.key);
            if(x>0){
                parent.right = node;
            }else{
                parent.left = node;
            }
        }else{
            //插入的节点就是父节点
            this.root = node;
        }
        insertFixUp(node);

    }
    /**
     * 插入情况
     *  1.红黑树为空，将节点变黑色
     *  2.插入的key已经存在，不处理
     *  3.插入节点的父节点为黑色，不变（黑高不变）
     *
     *  4.插入节点的父节点为红色
     *      4.1叔父双红------>叔父染黑，爷爷变红，以爷爷节点为当前节点进行下一步处理
     *      4.2叔叔是黑或者不存在，父节点为爷爷节点的左子树
     *          4.2.1 LL 父变黑，爷爷变红，爷爷右旋
     *          4.2.2 LR 父左旋，得到LL,以父节点开始
     *       4.3 叔叔是黑或者不存在，父节点为爷爷节点的右子树
     *          4.3.1 RR 父变黑，爷变红，爷爷左旋
     *          4.3.2 RL 父右旋，RR，   以父节点开始
     */
    private void insertFixUp(RBNode node) {
        this.root.setColor(BLACK);

        RBNode parent = parentOf(node);
        RBNode gparent = parentOf(node.parent);
        //情景四：
        if(parent!=null&&isRed(parent)){
            //如果父节点时红色，一定存在爷爷节点
            RBNode uncle = null;
            if(parent == gparent.left){
                uncle = gparent.right;
                //4.1叔父双红
                if(uncle!=null&&isRed(uncle)){
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    insertFixUp(gparent);
                    return;
                }
                //4.2
                if(uncle==null||isBlack(uncle)){
                    //4.2.1LL
                    if(node == parent.left){
                        setBlack(parent);
                        setRed(gparent);
                        rightRotate(gparent);
                        return;
                    }
                    //4.2.2
                    if(node == parent.right){
                        leftRotate(parent);
                        insertFixUp(parent);
                        return;
                    }
                }

            }else {
                uncle = gparent.left;
                //  4.1叔父双红
                if(uncle!=null&&isRed(uncle)){
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    insertFixUp(gparent);
                    return;
                }

                //4.3
                if(uncle==null||isBlack(uncle)){
                    //4.3.1
                    if(node ==parent.right){
                        setBlack(parent);
                        setRed(gparent);
                        leftRotate(gparent);
                        return;
                    }
                    //4.3.2
                    if(node ==parent.left){
                        rightRotate(parent);
                        insertFixUp(parent);
                        return;
                    }
                }
            }
        }
    }

    static class RBNode <k extends Comparable<k>,v>{
        private RBNode parent;
        private RBNode left;
        private RBNode right;
        private boolean color;
        private k key;
        private v value;

        public RBNode() {
        }

        public RBNode(RBNode parent, RBNode left, RBNode right, boolean color, k key, v value) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.color = color;
            this.key = key;
            this.value = value;
        }

        public RBNode getParent() {
            return parent;
        }

        public void setParent(RBNode parent) {
            this.parent = parent;
        }

        public RBNode getLeft() {
            return left;
        }

        public void setLeft(RBNode left) {
            this.left = left;
        }

        public RBNode getRight() {
            return right;
        }

        public void setRight(RBNode right) {
            this.right = right;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }

        public k getKey() {
            return key;
        }

        public void setKey(k key) {
            this.key = key;
        }

        public v getValue() {
            return value;
        }

        public void setValue(v value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RbTree<String,Object> rbt = new RbTree<>();
        while(true){
            System.out.println("请输入key");
            String key = scanner.next();
            System.out.println();
            rbt.insert(key,null);
            //打印红黑树
            print(rbt.root);
        }




    }

    public static void print(RBNode node){
        Queue<RBNode> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                RBNode node1 = queue.poll();
                System.out.println(node1.getKey()+"颜色"+node1.isColor());
                if(node1.left!=null)queue.add(node1.left);
                if(node1.right!=null)queue.add(node1.right);
            }
        }

    }

}
