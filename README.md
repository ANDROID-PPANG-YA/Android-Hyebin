# 1️⃣ First Week

실 기기로 작동 시키다보니, 계속해서 sumsung pass가 나오는 점 양해부탁드립니다..
<br>

![ezgif com-gif-maker](https://user-images.githubusercontent.com/69586104/162596292-4fc6d0c5-c51f-42ea-9cee-8df1624a2193.gif)



<br><br><br>

**1. SignIn**
  + 아이디, 비밀번호 모두 입력이 되있을 때만 로그인 버튼을 눌렀을때 HomeActivity로 이동
  
```kotlin
private fun initLoginBtn() {
    binding.apply {
        tvLogin.setOnClickListener {
            if(etId.text.isNotEmpty() && etPw.text.isNotEmpty()){
               toast(getString(R.string.sign_success))
               val intent = Intent(this@SignInActivity, HomeActivity::class.java)
               startActivity(intent)
               finish()
             } else {
                toast(getString(R.string.sign_fail))
             }
          }
     }
}
```

<br><br>
  + 회원가입에 성공한 뒤, 아이디&패스워드 자동 입력
  
```kotlin
resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
    if(result.resultCode == Activity.RESULT_OK){
         val id = result.data?.getStringExtra("id")
         val pw = result.data?.getStringExtra("pw")
         binding.etId.setText(id)
         binding.etPw.setText(pw)
    }
}
```

<br><br>

  + EditText의 hint 속성 및 비밀번호의 inputType 속성
  

```kotlin
android:hint="@string/sign_in_pw_hint"
android:inputType="textPassword"
```
<br><br><br>

**2. Home**
  + 사진 비율 맞추기
```kotlin
app:layout_constraintDimensionRatio="1:1"
```
<br><br>

  + 스크롤뷰 적용
```kotlin
<ScrollView
    android:layout_width="match_parent"
    android:layout_height="match_parent">
```
<br><br>

  + MVVM & 데이터 바인딩 사용

<br>

HomeViewModel
```kotlin
val homeData = HomeData("이혜빈", "23", "ESFJ", "안녕하세요 안드로이드파트 이혜빈입니다\n".repeat(100))
```

<br>

HomeActivity
```kotlin
private val viewModel: HomeViewModel by viewModels()

private fun initViewModel() {
        binding.data = viewModel
    }
```
<br>

activity_home.xml
```kotlin
<data>

    <variable
         name="data"
         type="com.sopt.anroid_hyebin.presentation.home.HomeViewModel" />
</data>  
```

<br>

```kotlin
android:text="@{data.homeData.name}"
```
<br><br> 

**3. SignUp**
  + 회원가입 완료 버튼 눌렀을 때 아이디, 비밀번호 값 넘겨주기
```kotlin
 //회원가입 버튼 이벤트
  private fun initFinishBtn() {
     binding.apply {
         tvFinish.setOnClickListener {
             if (etName.text.isNotEmpty() && etId.text.isNotEmpty() && etPw.text.isNotEmpty()) {
                 val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                 intent
                      .putExtra("id", etId.text.toString())
                      .putExtra("pw", etPw.text.toString())
                  setResult(RESULT_OK, intent)
                  finish()
              } else {
                  toast(getString(R.string.sign_up_fail))
              }
          }
      }
  }
```
<br><br>

**✅viewbinding**
- findViewById를 쓰지 않고, XML의 view component에 접근하는 object를 반환받아 view에 접근하는 방식
- Type-safe: view binding은 layout 내부에 정확한 view 타입을 찾아 mapping하므로 해당 view의 속성으로 접근할때 해당 view에 맞는 속성값을 노출시킴. 
- Null-safe: 여러 설정이 존재하는 layout의 경우 해당 설정에 맞는 view만 찾아 냄. 그리고 그렇지 않은경우 @Nullable 속성으로 만듭니다.

<br>

**✅databinding**
- 데이터바인딩은 XML레이아웃에 데이터를 바인딩해서 xml레이아웃이 View를 조작하므로,UI 컨트롤러(Activity/Fragment)에 불필요한 코드를 줄이는 방법
- findViewById() 사용 X (binding 객체를 통해 view 바로 접근가능)
- RecyclerView 사용 시 각각의 item들을 일일이 set하지 않아도 알아서 xml에서 처리 가능
- Observable을 이용해 실시간으로 데이터 변경 시 View를 Update 가능

<br><br><br><br>
*** 
<br>

**🤍이번 과제를 통해 배운 내용🤍**

<br>

☝ registerForActivityResult에 대해 이해했습니다.

✌ mvvm과 databinding의 개념을다시 잡는 시간을 가졌습니다.

👌 groovy에서 kts로  법을 익혔습니다.


<br><br><br>

# 2️⃣ Second Week

<br>

![ezgif com-gif-maker](https://user-images.githubusercontent.com/69586104/164644152-f5fc6fb0-7d3e-45b5-901b-ebc1d3269b5a.gif)



<br><br><br>

**1. HomeActivity**
<br>
fragment transaction는 아래와 같은 코드를 콩해 구현했습니다.

```kotlin
private fun initTransactionEvent() {
        val followerFragment = FollowerFragment()
        val repositoryFragment = RepositoryFragment()

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, followerFragment).commit()

        binding.tvFollower.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, followerFragment).commit()
        }

        binding.tvRepository.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, repositoryFragment).commit()
        }

    }
```

<br><br>
  + FollowerFragment

```kotlin
private fun initAdapter() {
        followerAdapter = FollowerAdapter()
        binding.rvFollower.adapter = followerAdapter

        followerAdapter.followerList.addAll(
            listOf(
                FollowerData("이혜빈1", "안녕하세요"),
                FollowerData("이혜빈2", "안녕하세요"),
                FollowerData("이혜빈3", "안녕하세요"),
                FollowerData("이혜빈4", "안녕하세요"),
                FollowerData("이혜빈5", "안녕하세요"),
                FollowerData("이혜빈6", "안녕하세요"),
                FollowerData("이혜빈7", "안녕하세요")
            )
        )
        followerAdapter.notifyDataSetChanged()
    }
```


<br><br><br>

**FollowerAdapter**
```kotlin
class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {
    val followerList = mutableListOf<FollowerData>()

    class FollowerViewHolder(val binding : ItemFollowerListBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(data: FollowerData) {
            binding.tvName.text = data.name
            binding.tvIntroduction.text = data.introduction
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val binding = ItemFollowerListBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(followerList[position])
        holder.binding.root.setOnClickListener {
            val intent = Intent(holder.itemView?.context, DetailActivity::class.java)
            intent.putExtra("name", followerList[position].name)
            intent.putExtra("introduction", followerList[position].introduction)
            startActivity(holder.itemView.context, intent, null)

        }
    }

    override fun getItemCount(): Int = followerList.size
}
```
<br><br>

  + activity_home.xml
```kotlin
<androidx.fragment.app.FragmentContainerView
                android:id="@+id/fragment_container"
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_marginTop="24dp"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintHorizontal_bias="1.0"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/cl_btn" />
```
<br><br>

  + fragment_follower.xml

<br>

```kotlin
<androidx.recyclerview.widget.RecyclerView
            android:id="@+id/rv_follower"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            tools:itemCount="4"
            tools:listitem="@layout/item_follower_list" />
```

<br><br>

**2. DetailActivity**
  + followerAdapter에서 item 파악 후, intent로 넘겨주기
```kotlin
    private fun initDetail() {
        val name = intent.getStringExtra("name")
        val introduce = intent.getStringExtra("introduction")
        binding.tvName.text = name
        binding.tvIntroduction.text = introduce
    }
```

**3. ItemDecoration**
  + swip 했을 때 같이 넘어가는게 큰 문제점이라고 파악해서, 구분 선만 추가했습니다.
```kotlin
    private fun recyclerViewDecoration() {
        val spaceDecoration = ItemDecoration(16)
        val dividerItemDecoration =
            DividerItemDecoration(
                binding.rvFollower.context,
                LinearLayoutManager(requireContext()).orientation
            )
        binding.rvFollower.addItemDecoration(dividerItemDecoration)
        binding.rvFollower.addItemDecoration(spaceDecoration)
    }
```

<br>

 + 아래와 같은 방식으로 Activity에서 해당 Fragment에서 활용합니다.
```kotlin
    private fun recyclerViewDecoration() {
        val spaceDecoration = ItemDecoration(16)
        val dividerItemDecoration =
            DividerItemDecoration(
                binding.rvFollower.context,
                LinearLayoutManager(requireContext()).orientation
            )
        binding.rvFollower.addItemDecoration(dividerItemDecoration)
        binding.rvFollower.addItemDecoration(spaceDecoration)
    }
```

<br><br>

<br>

**🤍이번 과제를 통해 배운 내용🤍**

<br>

☝ itemDecoration에 대해 더욱 공부해야되겠다고 생각했습니다.

✌ 시험기간으로 인해 스와이프 등등 recyclerview item에 대해 다루다가 말았는데... 꼭 시간내서 공부를 해야겠다고 느꼈습니다! 시험끝나고 꼭 할거에요 진짜진짜

👌 코드를 깔끔하게 짜기 위해서는 충분히 시간을 투자해야겠다고 생각했습니다... 데이터를 다루는 부분 등등에서 아쉬운 부분이 많은데 우선 제출하고.. 후에 리팩토링 하겠습니다!

<br><br><br><br>

# 3️⃣ Third Week

|gif|
|---|
|![ezgif com-gif-maker](https://user-images.githubusercontent.com/69586104/167091076-e200d76d-c3c7-464d-abde-89a0ec4153a3.gif)|

<br><br>

## LEVEL1

<br><br>

**1-1. 과제에 폰트 적용하기**


```kotlin
android:text="@string/sign_in_sign_up"
android:textSize="25sp"
android:textColor="@color/sopt_black"
android:fontFamily="@font/notosanskr_bold"
```

<br><br>

**1-2. 버튼 Selector 활용하기**

```kotlin
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:drawable="@drawable/rectangle_fill_sopt_main_purple_5dp" android:state_selected="true" />
    <item android:drawable="@drawable/rectangle_fill_f6f5f9_border_gray_radius_5dp" android:state_selected="false"/>
</selector>
```

<br><br>

**1-3. 이미지 원형으로 보이게하기**

```kotlin
    @JvmStatic
    @BindingAdapter("imageBind")
    fun setImage(imageView: ImageView, imageUrl: Int) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .circleCrop()
            .into(imageView)

    }
```

<br><br>
✍bindingAdapter를 사용하여 xml에서 처리했습니다.
<br>

**1-4. 깃허브 이미지 export하여 사용했습니다!**

<br><br>

**1-5. Activiy 하단에 BottomNavigaton 넣어주기**

```kotlin
<com.google.android.material.bottomnavigation.BottomNavigationView
            android:id="@+id/bnv_main"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@color/white"
            app:itemIconTint="@drawable/selector_bottom_navi"
            app:itemRippleColor="#6424D5"
            app:itemTextColor="@drawable/selector_bottom_navi"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:menu="@menu/menu" />
```

<br><br>


**2. 중첩스크롤 문제 해결하기**

```kotlin
class NestedScrollableHost : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    private var touchSlop = 0
    private var initialX = 0f
    private var initialY = 0f
    private val parentViewPager: ViewPager2?
        get() {
            var v: View? = parent as? View
            while (v != null && v !is ViewPager2) {
                v = v.parent as? View
            }
            return v as? ViewPager2
        }

    private val child: View? get() = if (childCount > 0) getChildAt(0) else null

    init {
        touchSlop = ViewConfiguration.get(context).scaledTouchSlop
    }

    private fun canChildScroll(orientation: Int, delta: Float): Boolean {
        val direction = -delta.sign.toInt()
        return when (orientation) {
            0 -> child?.canScrollHorizontally(direction) ?: false
            1 -> child?.canScrollVertically(direction) ?: false
            else -> throw IllegalArgumentException()
        }
    }

    override fun onInterceptTouchEvent(e: MotionEvent): Boolean {
        handleInterceptTouchEvent(e)
        return super.onInterceptTouchEvent(e)
    }

    private fun handleInterceptTouchEvent(e: MotionEvent) {
        val orientation = parentViewPager?.orientation ?: return

        if (!canChildScroll(orientation, -1f) && !canChildScroll(orientation, 1f)) {
            return
        }

        if (e.action == MotionEvent.ACTION_DOWN) {
            initialX = e.x
            initialY = e.y
            parent.requestDisallowInterceptTouchEvent(true)
        } else if (e.action == MotionEvent.ACTION_MOVE) {
            val dx = e.x - initialX
            val dy = e.y - initialY
            val isVpHorizontal = orientation == ORIENTATION_HORIZONTAL

            val scaledDx = dx.absoluteValue * if (isVpHorizontal) .5f else 1f
            val scaledDy = dy.absoluteValue * if (isVpHorizontal) 1f else .5f

            if (scaledDx > touchSlop || scaledDy > touchSlop) {
                if (isVpHorizontal == (scaledDy > scaledDx)) {
                    parent.requestDisallowInterceptTouchEvent(false)
                } else {
                    if (canChildScroll(orientation, if (isVpHorizontal) dx else dy)) {
                        parent.requestDisallowInterceptTouchEvent(true)
                    } else {
                        parent.requestDisallowInterceptTouchEvent(false)
                    }
                }
            }
        }
    }

```
✍NestedScrollableHost 공식문서 코드를 참고하여 작성하였습니다.

<br><br>

**3. 갤러리에서 받아온 이미지 화면에 띄우기**

```kotlin
    private fun aboutPermission() {
        binding.tvAdd.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                selectImage()
            } else if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_DENIED
            ) {
                requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        }
    }


    private fun selectImage() {
        getContent.launch("image/*")
    }
```

✍permission을 통해 권한을 요청하고, 그에 따라 처리를 하도록 코드를 작성했습니다.

<br><br>



**🤍이번 과제를 통해 배운 내용 & 성장한 내용🤍**

<br>

**☝ViewPager2 중첩스크롤에 대해 알아봤습니다.**
<br>
저번기수에 활동할 때에는 포기를 했던 부분이었는데, 이번 기회를 통해 공식문서와 공식 코드를 찾아보며 공부하는 시간을 가졌습니다.
<br>
사실 완전히 이해는 하지 못했지만, 차차 더 공부해보겠습니다..
<br><br>

**✌갤러리 접근에 대해 이해했습니다.**
<br>
사실 솝커톤 당시에는 아무렇게나 코드를 가져다 썼는데, 이제는 이해를 조금은 했습니다!
<br>
나중에 멀티파트 폼데이터를 한번 다뤄보고싶네여 :)

<br><br><br>
