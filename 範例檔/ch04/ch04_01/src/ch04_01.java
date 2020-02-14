// �ΰ}�C�������|

import java.io.*; 

class StackByArray { //�H�}�C�������|�����O�ŧi
   private int[] stack; //�b���O���ŧi�}�C
   private int top;  //���V���|���ݪ�����
   //StackByArray���O�غc�l
   public StackByArray(int stack_size) {
      stack=new int[stack_size]; //�إ߰}�C
      top=-1;
   }
      //���O��k�Gpush
   //�s�񳻺ݸ��,�ç󥿷s���|�����e.
   public boolean push(int data) {
      if (top>=stack.length) { //�P�_���|���ݪ����ެO�_�j��}�C�j�p
         System.out.println("���|�w��,�L�k�A�[�J");
         return false;
      }
      else {
         stack[++top]=data; //�N��Ʀs�J���|
         return true;
      }
   }
   //���O��k�Gempty
   //�P�_���|�O�_���Ű��|,�O�h�Ǧ^true,���O�h�Ǧ^false.
   public boolean empty() {
      if (top==-1) return true;
      else         return false;
   }
   //���O��k�Gpop
   //�q���|���X���
   public int pop() {
      if(empty()) //�P�_���|�O�_���Ū�,�p�G�O�h�Ǧ^-1��
        return -1;
      else
        return stack[top--]; //���N��ƨ��X��,�A�N���|���Щ��U��
   }
}
//�D���O���ŧi
public class ch04_01 {
   public static void main(String args[]) throws IOException {
      BufferedReader buf;
      int value;
      StackByArray stack =new StackByArray(10);
      buf=new BufferedReader(
                   new InputStreamReader(System.in));
      System.out.println("�Ш̧ǿ�J10����ơG");
      for (int i=0;i<10;i++) {
         value=Integer.parseInt(buf.readLine());
         stack.push(value);
      }
      System.out.println("=============================");
      while (!stack.empty()) //�N���|��Ƴ���q���ݼu�X
         System.out.println("���|�u�X�����Ǭ�:"+stack.pop());
   }
}