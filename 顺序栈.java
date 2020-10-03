/**
 2 * 功能:基于数组的顺序栈
 3 * @author:小鹿
 4 *
 5 */
 6public class ArrayStack {
    7
    8   private String[] items;  // 数组
    9   private int count;       // 栈中元素个数
   10   private int n;           // 栈的大小
   11
   12   // 初始化数组，申请一个大小为 n 的数组空间
   13   public ArrayStack(int n) {
   14     this.items = new String[n];
   15     this.n = n;
   16     this.count = 0;
   17   }
   18
   19   /**
   20    * 功能:入栈
   21    * 说明:数组入栈的入口为数组尾部
   22    * @param item :入栈数据元素
   23    * @return:是否入栈成功
   24    */
   25   public boolean push(String item) {
   26     // 数组空间不够了，直接返回 false，入栈失败。
   27     if (count == n) return false;
   28     // 将 item 放到下标为 count 的位置
   29     items[count] = item;
   30     //数组长度+1
   31     ++count;
   32     //入栈成功
   33     return true;
   34   }
   35
   36   /**
   37    * 功能:出栈
   38    * @return:返回出栈元素
   39    */
   40   public String pop() {
   41     // 栈为空，则直接返回 null
   42     if (count == 0) return null;
   43     // 返回下标为 count-1 的数组元素
   44     String tmp = items[count-1];
   45     //数组长度-1
   46     --count;
   47     //返回出栈数据元素
   48     return tmp;
   49   }
   50}