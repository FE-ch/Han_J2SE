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
	
	//头节点
	public Child(Child nextCh) {
		this.nextChild = nextCh;
	}
	
	//非头节点
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

//环形链表
class DoubleCycList implements List {

  public Child firstChild; //头指针
  public Child currentChild;//当前结点对象
  public int size;//结点个数

  //初始化一个空链表
  public DoubleCycList() {
      //初始化头结点，让头指针指向头结点。并且让当前结点对象等于头结点。
      this.firstChild = currentChild = new Child(null);
      this.size = 0;//单向链表，初始长度为零。
      this.firstChild.nextChild = firstChild;
      this.firstChild.priorChild = firstChild;
  }

  //定位函数，实现当前操作对象的前一个结点，也就是让当前结点对象定位到要操作结点的前一个结点。
  public void index(int index) throws Exception {
      if (index < -1 || index > size - 1) {
          throw new Exception("参数错误！");
      }
      //说明在头结点之后操作。
      if (index == -1)
          return;
      currentChild = firstChild.nextChild;
      int j = 0;//循环变量
      while (currentChild != firstChild && j < index) {
          currentChild = currentChild.nextChild;
          j++;
      }

  }

  @Override
  public void delete(int index) throws Exception {
      //判断链表是否为空
      if (isEmpty()) {
          throw new Exception("链表为空，无法删除！");
      }
      if (index < 0 || index > size) {
          throw new Exception("参数错误！");
      }
      index(index - 1);//定位到要操作结点的前一个结点对象。
      currentChild.setNextChild(currentChild.nextChild.nextChild);
      currentChild.nextChild.setPriorChild(currentChild);
      size--;
  }

  @Override
  public int getChild(int index) throws Exception {
      // TODO Auto-generated method stub
      if (index < -1 || index > size - 1) {
          throw new Exception("参数非法！");
      }
      index(index);

      return currentChild.getNumber();
  }

  @Override
  public void insert(int index, Child child) throws Exception {
      // TODO Auto-generated method stub
      if (index < 0 || index > size) {
          throw new Exception("参数错误！");
      }
      index(index - 1);//定位到要操作结点的前一个结点对象。
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