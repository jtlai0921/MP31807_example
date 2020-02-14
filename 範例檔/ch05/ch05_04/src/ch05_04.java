// ��J��������V��C��@

import java.io.*;
class QueueNode                 // ��C�`�I���O
{
   int data;                    // �`�I���
   QueueNode next;              // ���V�U�@�Ӹ`�I
   //�غc�l
   public QueueNode(int data) {
       this.data=data;
       next=null;
   }
};

class Linked_List_Queue { //��C���O
   public QueueNode front; //��C���e�ݫ���
   public QueueNode rear;  //��C�����ݫ���

//�غc�l
   public Linked_List_Queue() { front=null; rear=null; }

//��kenqueue:��C��ƪ��s�J                          
public boolean enqueue(int value) {
   QueueNode node= new QueueNode(value); //�إ߸`�I
  //�ˬd�O�_���Ŧ�C
   if (rear==null)
      front=node; //�s�إߪ��`�I������1�Ӹ`�I
   else
      rear.next=node; //�N�`�I�[�J���C������
   rear=node; //�N��C�����ݫ��Ы��V�s�[�J���`�I
   return true;
}

//��kdequeue:��C��ƪ����X
public int dequeue(int action) {
   int value;
   QueueNode tempNode,startNode;
   //�q�e�ݨ��X���
   if (!(front==null) && action==1) {
     if(front==rear) rear=null;
     value=front.data; //�N��C��Ʊq�e�ݨ��X
     front=front.next; //�N��C���e�ݫ��Ы��V�U�@��
     return value; }
   //�q���ݨ��X���   
   else if(!(rear==null) && action==2) {
     startNode=front;  //���O�U�e�ݪ����Э�
     value=rear.data;  //���X�ثe���ݪ����
     //��M�̧��ݸ`�I���e�@�Ӹ`�I
     tempNode=front;
     while (front.next!=rear && front.next!=null) { front=front.next;tempNode=front;}
     front=startNode;  //�O���q���ݨ��X��ƫ᪺��C�e�ݫ���
     rear=tempNode;    //�O���q���ݨ��X��ƫ᪺��C���ݫ���
     //�U�@��{���O�����C���ȳѤU�̸`�I��,���X��ƫ�K�Nfront��rear���Vnull
     if ((front.next==null) || (rear.next==null)) { front=null;rear=null; }
     return value; }
   else return -1;
 }
} //��C���O�ŧi����

public class ch05_04 {
// �D�{��
   public static void main(String args[]) throws IOException {
   Linked_List_Queue queue =new Linked_List_Queue(); //�إߦ�C����
   int temp;
   System.out.println("�H�쵲��C�ӹ�@���V��C");
   System.out.println("====================================");
   System.out.println("�b���V��C�e�ݥ[�J��1����ơA����ƭȬ�1");
   queue.enqueue(1);
   System.out.println("�b���V��C�e�ݥ[�J��2����ơA����ƭȬ�3");
   queue.enqueue(3);
   System.out.println("�b���V��C�e�ݥ[�J��3����ơA����ƭȬ�5");
   queue.enqueue(5);
   System.out.println("�b���V��C�e�ݥ[�J��4����ơA����ƭȬ�7");
   queue.enqueue(7);
   System.out.println("�b���V��C�e�ݥ[�J��5����ơA����ƭȬ�9");
   queue.enqueue(9);
   System.out.println("====================================");
   temp=queue.dequeue(1);
   System.out.println("�q���V��C�e�ݨ̧Ǩ��X��������ƭȬ��G"+temp);
   temp=queue.dequeue(2);
   System.out.println("�q���V��C���ݨ̧Ǩ��X��������ƭȬ��G"+temp);
   temp=queue.dequeue(1);
   System.out.println("�q���V��C�e�ݨ̧Ǩ��X��������ƭȬ��G"+temp);
   temp=queue.dequeue(2);
   System.out.println("�q���V��C���ݨ̧Ǩ��X��������ƭȬ��G"+temp);
   temp=queue.dequeue(1);
   System.out.println("�q���V��C�e�ݨ̧Ǩ��X��������ƭȬ��G"+temp);
   System.out.println();
  }
}
