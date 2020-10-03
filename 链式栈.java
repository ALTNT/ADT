/**
 2 * 功能:基本链表实现栈，入栈、出栈、输出栈
 3 * @author : 小鹿
 4 *
 5 */
 6public class StackBasedLinkedList {
    7    //定义栈顶指针
    8    private Node top = null;
    9
   10    //定义栈结点
   11    private static class Node {
   12        //栈结点数据域
   13        private int data;
   14        //栈结点指针域
   15        private Node next;
   16        //构造函数
   17        public Node(int data, Node next) {
   18          this.data = data;
   19          this.next = next;
   20        }
   21        //get 获取数据域方法
   22        public int getData() {
   23          return data;
   24        }
   25    }
   26
   27    /**
   28     * 功能:入栈
   29     * @param value:要入栈的数据元素
   30     */
   31    public void push(int value) {
   32        //创建一个栈结点 
   33        Node newNode = new Node(value, null);
   34        // 判断栈是否为空
   35        if (top == null) {
   36          //如果栈为空，就将入栈的值作为栈的第一个元素
   37          top = newNode;
   38        } else {
   39          //否则插入到top栈结点前（所谓的就是单链表的头插法）
   40          newNode.next = top;
   41          top = newNode;
   42        }
   43    }
   44
   45    /**
   46     * 功能 : 出栈
   47     * @return: -1 为栈中没有数据
   48     */
   49    public int pop() {
   50        // 如果栈的最顶层栈结点为null,栈为空
   51        if (top == null) return -1;
   52
   53        //否则执行出栈操作，现将栈顶结点的数据元素赋值给 Value
   54        int value = top.data;
   55        //将 top 指针向下移动
   56        top = top.next;
   57        //返回出栈的值
   58        return value;
   59    }   
   60
   61    /**
   62     * 功能:输出栈中所有元素
   63     */
   64    public void printAll() {
   65        //将栈顶指针赋值给p
   66        Node p = top;
   67        //循环遍历栈(遍历单链表)
   68        while (p != null) {
   69          System.out.print(p.data + " ");
   70          //指向下一个结点
   71          p = p.next;
   72        }
   73        System.out.println();
   74    }
   75}