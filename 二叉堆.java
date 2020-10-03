public class BinaryHeap {

    /**�ϸ��������Բ���Ľڵ�����ϸ�
     *
     * @param arr
     * @param length ����ʾ����ѵĳ���
     */
    public static int[] upAdjust(int arr[], int length){
        //��ǲ���Ľڵ�
        int child = length - 1;
        //�丸�׽ڵ�
        int parent = (child - 1)/2;
        //�Ѳ���Ľڵ���ʱ��������
        int temp = arr[child];
 
        //�����ϸ�
        while (child > 0 && temp < arr[parent]) {
            //��ʵ���ý���ÿ�ζ����н���������ֵ�Ϳ�����
            //��temp�ҵ���ȷ��λ��֮�������ٰ�temp��ֵ��������ڵ�
            arr[child] = arr[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        //�˳�ѭ�������ҵ���ȷ��λ��
        arr[child] = temp;
        return arr;
    }
 
    /**
 
     */
 
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
 
    /**
     * ��������
     *
     * @param arr
     */
    public static int[] buildHead(int[] arr,int length) {
        //�����һ����Ҷ�ӽڵ㿪ʼ�³�
        for (int i = (length - 2) / 2; i >= 0; i--) {
            arr = downAdjust(arr, i, length);
        }
        return arr;
    }
 }