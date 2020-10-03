/**
  2 * 2019/3/23
  3 * ���ں�:��һ������ƽ������ũ��
  4 * @author С¹
  5 * ���ܣ�������Ĳ��롢ɾ��������
  6 * �����롿�����뵽ָ��Ԫ�غ�
  7 * 1�����Ҹ�Ԫ���Ƿ���ڣ�
  8 * 2��û���ҵ����� -1
  9 * 3���ҵ����д�����㲢��������
 10 * 
 11 * �����ҡ�����ֵ����/����������
 12 * 1���жϵ�ǰ����Ƿ����null�����Ƿ���ڸ���ֵ��
 13 * 2���ж��Ƿ�����ҵ���ֵ��
 14 * 3��û���ҵ����� -1��
 15 * 4���ҵ���ֵ���ؽ�㣻
 16 * 
 17 * ��ɾ��������ֵɾ��
 18 * 1���ж��Ƿ��ҵ���ֵ��
 19 * 2���ҵ���¼ǰ��㣬����ɾ����
 20 * 3���Ҳ���ֱ�ӷ���-1��
 21 */
 22//������
 23class Node{
 24    constructor(data){
 25        this.data = data;
 26        this.next = null;
 27    }
 28}
 29
 30//��������
 31class LinkList{
 32    constructor(){
 33        //��ʼ��ͷ���
 34        this.head = new Node('head');
 35    }
 36
 37    //���� value ���ҽ��
 38    findByValue = (value) =>{
 39        let currentNode = this.head;
 40        while(currentNode !== null && currentNode.data !== value){
 41            currentNode = currentNode.next;
 42        }
 43        //�жϸý���Ƿ��ҵ�
 44        console.log(currentNode)
 45        return currentNode === null ? -1 : currentNode;
 46    }
 47
 48    //���� index ���ҽ��
 49    findByIndex = (index) =>{
 50        let pos = 0;
 51        let currentNode = this.head;
 52        while(currentNode !== null && pos !== index){
 53            currentNode = currentNode.next;
 54            pos++;
 55        }
 56        //�ж��Ƿ��ҵ�������
 57        console.log(currentNode)
 58        return currentNode === null ? -1 : currentNode;
 59    }
 60
 61    //����Ԫ��(ָ��Ԫ��������)
 62    insert = (value,element) =>{
 63        //�Ȳ��Ҹ�Ԫ��
 64        let currentNode = this.findByValue(element);
 65        //���û���ҵ�
 66        if(currentNode == -1){
 67            console.log("δ�ҵ�����λ��!")
 68            return;
 69        }
 70        let newNode = new Node(value);
 71        newNode.next = currentNode.next;
 72        currentNode.next = newNode;
 73    }
 74
 75    //����ֵɾ�����
 76    delete = (value) =>{
 77        let currentNode = this.head;
 78        let preNode = null;
 79        while(currentNode !== null && currentNode.data !== value){
 80            preNode = currentNode;
 81            currentNode = currentNode.next;
 82        }
 83        if(currentNode == null) return -1; 
 84        preNode.next = currentNode.next;
 85    }
 86
 87     //�������н��
 88    print = () =>{
 89        let currentNode = this.head
 90        //�����㲻Ϊ��
 91        while(currentNode !== null){
 92            console.log(currentNode.data)
 93            currentNode = currentNode.next;
 94        }
 95    }
 96}
 97
 98//����
 99const list = new LinkList()
100list.insert('xiao','head');
101list.insert('lu','xiao');
102list.insert('ni','head');
103list.insert('hellow','head');
104list.print()
105console.log('-------------ɾ��Ԫ��------------')
106list.delete('ni')
107list.delete('xiao')
108list.print()
109console.log('-------------��ֵ����------------')
110list.findByValue('lu')
111console.log('-------------����������------------')
112list.print()