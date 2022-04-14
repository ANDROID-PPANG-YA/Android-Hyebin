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
