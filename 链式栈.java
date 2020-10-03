/**
 2 * ����:��������ʵ��ջ����ջ����ջ�����ջ
 3 * @author : С¹
 4 *
 5 */
 6public class StackBasedLinkedList {
    7    //����ջ��ָ��
    8    private Node top = null;
    9
   10    //����ջ���
   11    private static class Node {
   12        //ջ���������
   13        private int data;
   14        //ջ���ָ����
   15        private Node next;
   16        //���캯��
   17        public Node(int data, Node next) {
   18          this.data = data;
   19          this.next = next;
   20        }
   21        //get ��ȡ�����򷽷�
   22        public int getData() {
   23          return data;
   24        }
   25    }
   26
   27    /**
   28     * ����:��ջ
   29     * @param value:Ҫ��ջ������Ԫ��
   30     */
   31    public void push(int value) {
   32        //����һ��ջ��� 
   33        Node newNode = new Node(value, null);
   34        // �ж�ջ�Ƿ�Ϊ��
   35        if (top == null) {
   36          //���ջΪ�գ��ͽ���ջ��ֵ��Ϊջ�ĵ�һ��Ԫ��
   37          top = newNode;
   38        } else {
   39          //������뵽topջ���ǰ����ν�ľ��ǵ������ͷ�巨��
   40          newNode.next = top;
   41          top = newNode;
   42        }
   43    }
   44
   45    /**
   46     * ���� : ��ջ
   47     * @return: -1 Ϊջ��û������
   48     */
   49    public int pop() {
   50        // ���ջ�����ջ���Ϊnull,ջΪ��
   51        if (top == null) return -1;
   52
   53        //����ִ�г�ջ�������ֽ�ջ����������Ԫ�ظ�ֵ�� Value
   54        int value = top.data;
   55        //�� top ָ�������ƶ�
   56        top = top.next;
   57        //���س�ջ��ֵ
   58        return value;
   59    }   
   60
   61    /**
   62     * ����:���ջ������Ԫ��
   63     */
   64    public void printAll() {
   65        //��ջ��ָ�븳ֵ��p
   66        Node p = top;
   67        //ѭ������ջ(����������)
   68        while (p != null) {
   69          System.out.print(p.data + " ");
   70          //ָ����һ�����
   71          p = p.next;
   72        }
   73        System.out.println();
   74    }
   75}