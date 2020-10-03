/**
 2 * ����:���������˳��ջ
 3 * @author:С¹
 4 *
 5 */
 6public class ArrayStack {
    7
    8   private String[] items;  // ����
    9   private int count;       // ջ��Ԫ�ظ���
   10   private int n;           // ջ�Ĵ�С
   11
   12   // ��ʼ�����飬����һ����СΪ n ������ռ�
   13   public ArrayStack(int n) {
   14     this.items = new String[n];
   15     this.n = n;
   16     this.count = 0;
   17   }
   18
   19   /**
   20    * ����:��ջ
   21    * ˵��:������ջ�����Ϊ����β��
   22    * @param item :��ջ����Ԫ��
   23    * @return:�Ƿ���ջ�ɹ�
   24    */
   25   public boolean push(String item) {
   26     // ����ռ䲻���ˣ�ֱ�ӷ��� false����ջʧ�ܡ�
   27     if (count == n) return false;
   28     // �� item �ŵ��±�Ϊ count ��λ��
   29     items[count] = item;
   30     //���鳤��+1
   31     ++count;
   32     //��ջ�ɹ�
   33     return true;
   34   }
   35
   36   /**
   37    * ����:��ջ
   38    * @return:���س�ջԪ��
   39    */
   40   public String pop() {
   41     // ջΪ�գ���ֱ�ӷ��� null
   42     if (count == 0) return null;
   43     // �����±�Ϊ count-1 ������Ԫ��
   44     String tmp = items[count-1];
   45     //���鳤��-1
   46     --count;
   47     //���س�ջ����Ԫ��
   48     return tmp;
   49   }
   50}