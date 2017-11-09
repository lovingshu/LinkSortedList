import java.util.LinkedList;

public class LinkSortedList<K,V extends Number> extends LinkedList<NumberEntry<String, ? extends Number>> {
	private static final long serialVersionUID = -7583151322562380641L;
	private int MAX_SIZE;
	public LinkSortedList(int fixedSize) throws Exception{
		if(fixedSize<1||fixedSize>Integer.MAX_VALUE){
			throw new Exception("specific size is incorrect!");
		}
		this.MAX_SIZE = fixedSize-1;
	}
	
	/**
	 * only this method can sort the elements!
	 */
	@Override
	public boolean add(NumberEntry<String,  ? extends Number> e) {
		Number ttick=e.getValue();
		//如果有数据,则直接减出结果,然后放入sortedMap中
		if(ttick!=null){
			//如果里面还没有数据,则先把第一条数据插入进去
			if(this.size()==0){
				this.add(0,new NumberEntry<>(e.getKey(),e.getValue()));
			}else{
				for(int i=0;i<this.size();i++){
					NumberEntry<String,? extends Number> t=this.get(i);
					if(ttick.doubleValue()<=t.getValue().doubleValue()){
						if(this.size()<=MAX_SIZE){
							this.add(i, new NumberEntry<>(e.getKey(),e.getValue()));
						}
						break;
					}else if(ttick.doubleValue()>t.getValue().doubleValue()&&i==this.size()-1){
						if(this.size()>=MAX_SIZE){
							this.remove(0);
							this.add(i,new NumberEntry<>(e.getKey(),e.getValue()));
						}else{
							this.add(i+1,new NumberEntry<>(e.getKey(),e.getValue()));
						}
						break;
					}
				}
			}
		}
		return true;
	}
}
