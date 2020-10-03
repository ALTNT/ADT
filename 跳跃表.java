//�ڵ�
2class Node{
    3    int value = -1;
    4    int level;//��Խ����
    5    Node[] next;//ָ����һ���ڵ�
    6
    7    public Node(int value, int level) {
    8        this.value = value;
    9        this.level = level;
   10        this.next = new Node[level];
   11    }
   12}
   13//��Ծ��
   14public class SkipList {
   15    //�����������
   16    int maxLevel = 16;
   17    //ͷ�ڵ㣬�䵱������
   18    Node head = new Node(-1, 16);
   19    //��ǰ��Ծ��ڵ�ĸ���
   20    int size = 0;
   21    //��ǰ��Ծ��Ĳ���,��ʼ��Ϊ1�㡣
   22    int levelCount = 1;
   23
   24
   25    public Node find(int value) {
   26        Node temp = head;
   27        for (int i = levelCount - 1; i >= 0; i--) {
   28            while (temp.next[i] != null && temp.next[i].value < value) {
   29                temp = temp.next[i];
   30            }
   31        }
   32        //�ж��Ƿ��и�Ԫ�ش���
   33        if (temp.next[0] != null && temp.next[0].value == value) {
   34            System.out.println(value + "  ���ҳɹ�");
   35            return temp.next[0];
   36        } else {
   37            return null;
   38        }
   39    }
   40    // Ϊ�˷��㣬��Ծ���ڲ����ʱ�򣬲���Ľڵ��ڵ�ǰ��Ծ���ǲ����ڵ�
   41    //����������ظ���ֵ�Ľڵ㡣
   42    public void insert(int value) {
   43        int level = getLevel();
   44        Node newNode = new Node(value, level);
   45        //update���ڼ�¼Ҫ����ڵ��ǰ��
   46        Node[] update = new Node[level];
   47
   48        Node temp = head;
   49        for (int i = level - 1; i >= 0; i--) {
   50            while (temp.next[i] != null && temp.next[i].value < value) {
   51                temp = temp.next[i];
   52            }
   53            update[i] = temp;
   54        }
   55        //�Ѳ���ڵ��ÿһ����������
   56        for (int i = 0; i < level; i++) {
   57            newNode.next[i] = update[i].next[i];
   58            update[i].next[i] = newNode;
   59        }
   60        //�ж��Ƿ���Ҫ������Ծ��Ĳ���
   61        if (level > levelCount) {
   62            levelCount = level;
   63        }
   64        size++;
   65        System.out.println(value + " ����ɹ�");
   66    }
   67
   68    public void delete(int value) {
   69        Node[] update = new Node[levelCount];
   70        Node temp = head;
   71
   72        for (int i = levelCount - 1; i >= 0; i--) {
   73            while (temp.next[i] != null && temp.next[i].value < value) {
   74                temp = temp.next[i];
   75            }
   76            update[i] = temp;
   77        }
   78
   79        if (temp.next[0] != null && temp.next[0].value == value) {
   80            size--;
   81            System.out.println(value + " ɾ���ɹ�");
   82            for (int i = levelCount - 1; i >= 0; i--) {
   83                if (update[i].next[i] != null && update[i].next[i].value == value) {
   84                    update[i].next[i] = update[i].next[i].next[i];
   85                }
   86            }
   87        }
   88    }
   89
   90    //��ӡ���нڵ�
   91    public void printAllNode() {
   92        Node temp = head;
   93        while (temp.next[0] != null) {
   94            System.out.println(temp.next[0].value + "  ");
   95            temp = temp.next[0];
   96        }
   97    }
   98
   99    //ģ����Ӳ��
  100    private int getLevel() {
  101        int level = 1;
  102        while (true) {
  103            int t = (int)(Math.random() * 100);
  104            if (t % 2 == 0) {
  105                level++;
  106            } else {
  107                break;
  108            }
  109        }
  110        System.out.println("��ǰ��level = " + level);
  111        return level;
  112    }
  113
  114    //��������
  115    public static void main(String[] args) {
  116        SkipList list = new SkipList();
  117        for (int i = 0; i < 6; i++) {
  118            list.insert(i);
  119        }
  120        list.printAllNode();
  121        list.delete(4);
  122        list.printAllNode();
  123        System.out.println(list.find(3));
  124        System.out.println(list.size + " " + list.levelCount);
  125    }
  126}