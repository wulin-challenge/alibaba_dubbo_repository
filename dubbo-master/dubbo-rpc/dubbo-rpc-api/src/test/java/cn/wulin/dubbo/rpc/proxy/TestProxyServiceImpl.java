package cn.wulin.dubbo.rpc.proxy;

public class TestProxyServiceImpl implements TestProxyService{
	
	private Integer age = 0;

	@Override
	public void hi(String name) {
		System.out.println("hi params 1 "+name+" ,age: "+age);
	}

	@Override
	public String hi(String name, String password) {
		System.out.println("hi params 1 "+name+" , params 2 "+password+" ,age: "+age);
		return name+":"+password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
