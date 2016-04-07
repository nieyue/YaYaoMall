hibernate注解annotation
@Entity配置实体类
@Table配置表名
@Embeddable;可嵌入类，在别的类中充当属性，结合@EmbeddedId实现一对一联合主键
@Id主键
@GeneratedValue配置主键策略等
@Column对应数据库表中字段
@Embedded标注一个实体类的嵌入类
@EmbeddedId嵌入主键id
@Transient忽略生成表中的字段

1,一对一
Student的属性sid 和Card的属性cid
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="sid",unique=true)
private Card card;

@OneToOne(mappedBy="cid")
private Student stu;//学生是主控方，身份证是被控方

2,多对一,设置EAGER,表示积极加载
Student的属性sid 和ClassRoom的属性cid
@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
@JoinColumn(name="cid",referencedColumnName="CID")
private ClassRoom classRoom;

3,一对多,设置LAZY,懒加载
Student的属性sid 和ClassRoom的属性cid
@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
@JoinColumn(name="cid")
private Set<Student> stus;

4,多对多
Student的属性sid 和Teacher的属性tid
@ManyToMany
@JoinTable(
	name="teacher_student",
	joinColumns={@JoinColumn(name="sid")},
	inverseJoinColumns={@JoinColumn(name="tid")})
private Set<Teacher> teacher;
	
@ManyToMany(mappedBy="teacher")
private Set<Student> stus;//学生是主控方。教师是被控方