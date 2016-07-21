package Han_JavaSE;
interface List {
	public int size();
	
	public boolean isEmpty();
	
	public void insert(int index, Child child) throws Exception;
	
	public void delete(int index) throws Exception;
	
	public int getChild(int index) throws Exception;
}

class Child {
	public int number;
	public Child nextChild;
	public Child priorChild;
	
	//ͷ�ڵ�
	public Child(Child nextCh) {
		this.nextChild = nextCh;
	}
	
	//��ͷ�ڵ�
	public Child(int number, Child nextCh) {
		this.number = number;
		this.nextChild = nextCh;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public Child getNextChild() {
		return this.nextChild;
	}
	
	public Child getPriorChild() {
		return this.priorChild;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void setPriorChild(Child priorCh) {
		this.priorChild = priorCh;
	}
	
	public void setNextChild(Child nextCh) {
		this.nextChild = nextCh;
	}
	
}

//��������
class DoubleCycList implements List {

  public Child firstChild; //ͷָ��
  public Child currentChild;//��ǰ������
  public int size;//������

  //��ʼ��һ��������
  public DoubleCycList() {
      //��ʼ��ͷ��㣬��ͷָ��ָ��ͷ��㡣�����õ�ǰ���������ͷ��㡣
      this.firstChild = currentChild = new Child(null);
      this.size = 0;//����������ʼ����Ϊ�㡣
      this.firstChild.nextChild = firstChild;
      this.firstChild.priorChild = firstChild;
  }

  //��λ������ʵ�ֵ�ǰ���������ǰһ����㣬Ҳ�����õ�ǰ������λ��Ҫ��������ǰһ����㡣
  public void index(int index) throws Exception {
      if (index < -1 || index > size - 1) {
          throw new Exception("��������");
      }
      //˵����ͷ���֮�������
      if (index == -1)
          return;
      currentChild = firstChild.nextChild;
      int j = 0;//ѭ������
      while (currentChild != firstChild && j < index) {
          currentChild = currentChild.nextChild;
          j++;
      }

  }

  @Override
  public void delete(int index) throws Exception {
      //�ж������Ƿ�Ϊ��
      if (isEmpty()) {
          throw new Exception("����Ϊ�գ��޷�ɾ����");
      }
      if (index < 0 || index > size) {
          throw new Exception("��������");
      }
      index(index - 1);//��λ��Ҫ��������ǰһ��������
      currentChild.setNextChild(currentChild.nextChild.nextChild);
      currentChild.nextChild.setPriorChild(currentChild);
      size--;
  }

  @Override
  public int getChild(int index) throws Exception {
      // TODO Auto-generated method stub
      if (index < -1 || index > size - 1) {
          throw new Exception("�����Ƿ���");
      }
      index(index);

      return currentChild.getNumber();
  }

  @Override
  public void insert(int index, Child child) throws Exception {
      // TODO Auto-generated method stub
      if (index < 0 || index > size) {
          throw new Exception("��������");
      }
      index(index - 1);//��λ��Ҫ��������ǰһ��������
      currentChild.setNextChild(new Child(index, currentChild.nextChild));
      currentChild.nextChild.setPriorChild(currentChild);
      currentChild.nextChild.nextChild.setPriorChild(currentChild.nextChild);

      size++;
  }

  @Override
  public boolean isEmpty() {
      // TODO Auto-generated method stub
      return size == 0;
  }

  @Override
  public int size() {
      // TODO Auto-generated method stub
      return this.size;
  }



}

public class Joseph {

	public static void main(String[] args) {
		
	}
}