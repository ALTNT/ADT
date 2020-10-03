public class HeapSort {
    /**
     *  �³�������ִ��ɾ�������൱�ڰ����
     *  * һ��Ԫ�ظ�����Ԫ��֮��Ȼ��Ը�Ԫ��ִ���³�����
     * @param arr
     * @param parent Ҫ�³�Ԫ�ص��±�
     * @param length ���鳤��
     */
    public static int[] downAdjust(int[] arr, int parent, int length) {
        //��ʱ��֤Ҫ�³���Ԫ��
        int temp = arr[parent];
        //��λ���ӽڵ�λ��
        int child = 2 * parent + 1;
        //��ʼ�³�
        while (child < length) {
            //����Һ��ӽڵ������С����λ���Һ���
            if (child + 1 < length && arr[child] > arr[child + 1]) {
                child++;
            }
            //������ڵ�Ⱥ��ӽڵ�С����ڣ����³�����
            if (temp <= arr[child])
                break;
            //����ֵ
            arr[parent] = arr[child];
            parent = child;
            child = 2 * parent + 1;
        }
        arr[parent] = temp;
        return arr;
    }
 
    //������
    public static int[] heapSort(int[] arr, int length) {
        //���������
        for (int i = (length - 2) / 2; i >= 0; i--) {
            arr = downAdjust(arr, i, length);
        }
        //���ж�����
        for (int i = length - 1; i >= 1; i--) {
            //�ѶѶ���Ԫ�������һ��Ԫ�ؽ���
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            //�³�����
            arr = downAdjust(arr, 0, i);
        }
        return arr;
    }
    //����
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5,2, 0,10,6};
        System.out.println(Arrays.toString(arr));
        arr = heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
 }