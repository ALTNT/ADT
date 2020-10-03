/**
  2 * 2019/3/23
  3 * 公众号:「一个不甘平凡的码农」
  4 * @author 小鹿
  5 * 功能：单链表的插入、删除、查找
  6 * 【插入】：插入到指定元素后方
  7 * 1、查找该元素是否存在？
  8 * 2、没有找到返回 -1
  9 * 3、找到进行创建结点并插入链表。
 10 * 
 11 * 【查找】：按值查找/按索引查找
 12 * 1、判断当前结点是否等于null，且是否等于给定值？
 13 * 2、判断是否可以找到该值？
 14 * 3、没有找到返回 -1；
 15 * 4、找到该值返回结点；
 16 * 
 17 * 【删除】：按值删除
 18 * 1、判断是否找到该值？
 19 * 2、找到记录前结点，进行删除；
 20 * 3、找不到直接返回-1；
 21 */
 22//定义结点
 23class Node{
 24    constructor(data){
 25        this.data = data;
 26        this.next = null;
 27    }
 28}
 29
 30//定义链表
 31class LinkList{
 32    constructor(){
 33        //初始化头结点
 34        this.head = new Node('head');
 35    }
 36
 37    //根据 value 查找结点
 38    findByValue = (value) =>{
 39        let currentNode = this.head;
 40        while(currentNode !== null && currentNode.data !== value){
 41            currentNode = currentNode.next;
 42        }
 43        //判断该结点是否找到
 44        console.log(currentNode)
 45        return currentNode === null ? -1 : currentNode;
 46    }
 47
 48    //根据 index 查找结点
 49    findByIndex = (index) =>{
 50        let pos = 0;
 51        let currentNode = this.head;
 52        while(currentNode !== null && pos !== index){
 53            currentNode = currentNode.next;
 54            pos++;
 55        }
 56        //判断是否找到该索引
 57        console.log(currentNode)
 58        return currentNode === null ? -1 : currentNode;
 59    }
 60
 61    //插入元素(指定元素向后插入)
 62    insert = (value,element) =>{
 63        //先查找该元素
 64        let currentNode = this.findByValue(element);
 65        //如果没有找到
 66        if(currentNode == -1){
 67            console.log("未找到插入位置!")
 68            return;
 69        }
 70        let newNode = new Node(value);
 71        newNode.next = currentNode.next;
 72        currentNode.next = newNode;
 73    }
 74
 75    //根据值删除结点
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
 87     //遍历所有结点
 88    print = () =>{
 89        let currentNode = this.head
 90        //如果结点不为空
 91        while(currentNode !== null){
 92            console.log(currentNode.data)
 93            currentNode = currentNode.next;
 94        }
 95    }
 96}
 97
 98//测试
 99const list = new LinkList()
100list.insert('xiao','head');
101list.insert('lu','xiao');
102list.insert('ni','head');
103list.insert('hellow','head');
104list.print()
105console.log('-------------删除元素------------')
106list.delete('ni')
107list.delete('xiao')
108list.print()
109console.log('-------------按值查找------------')
110list.findByValue('lu')
111console.log('-------------按索引查找------------')
112list.print()