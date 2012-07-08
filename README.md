StateSaver
======================
Android用ユーティリティ。  
BundleまたはPreferenceに対するActivity状態の保存/復元を自動化してくれます。
 
使い方
------
### 1. StateSaverの読み込み ###
StateSaverを利用したいプロジェクトにStateSaverプロジェクトもしくは、  
jarファイルをビルドパスに通してください。

 
### 2. Activityでの使い方(Bundleへの保存) ###
StateSaverを利用したいActivityで、以下を参考に実装を行ってください。
    
    // Bundleへ保存/復元したいインスタンス変数に
    // SaveToBundleアノテーションを設定します。
    @SaveToBundle
    int count;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        
        try{
            // SaveToBundleアノテーションが設定されたインスタンス変数を
            // Bundleへ保存します。
            AutoStateSaver.getAutoStateSaver().saveToBundle(outState, this);
            
        }catch(NotSupportedBundleTypeException e){
            // Bundleへ保存できない型を指定した場合、
            // 実行時例外が発生します。
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // SaveToBundleアノテーションが設定されたインスタンス変数へ
        // Bundleの値を復元します。
        AutoStateSaver.getAutoStateSaver().restoreFromBundle(savedInstanceState, this);
    }

### 3. Activityでの使い方(Preferenceへの保存) ###
StateSaverを利用したいActivityで、以下を参考に実装を行ってください。
    
    // Preferenceへ保存/復元したいインスタンス変数に
    // SaveToPreferenceアノテーションを設定します。
    @SaveToPreference
    int count;

    @Override
    protected void onPause() {
        super.onPause();
        
        try{
            // SaveToPreferenceアノテーションが設定されたインスタンス変数を
            // Preferenceへ保存します。
            AutoStateSaver.getAutoStateSaver().saveToPreference(this, this);
            
        }catch(NotSupportedPreferenceTypeException e){
            // Preferenceへ保存できない型を指定した場合、
            // 実行時例外が発生します。
        }
    }

    // 任意のタイミング(onCreate等)で値を復元します。
    private void loadFromPreference() {
        // SaveToPreferenceアノテーションが設定されたインスタンス変数へ
        // Bundleの値を復元します。
        AutoStateSaver.getAutoStateSaver().restoreFromPreference(this, this);
    }

サポートする型(Bundle)
------
### 1. プリミティブ型 ###
全てのプリミティブ型と、その配列を保存/復元対象とすることができます。

* `short`, `short[]`
* `int`, `int[]`
* `long`, `long[]`
* `float`, `float[]`
* `double`, `double[]`
* `byte`, `byte[]`
* `boolean`, `boolean[]`
* `char`, `char[]`

### 2. ラッパーオブジェクト ###
プリミティブ型に対応するラッパーオブジェクトと、その配列を保存/復元対象とすることができます。

* `Short`, `Short[]`
* `Integer`, `Integer[]`
* `Long`, `Long[]`
* `Float`, `Float[]`
* `Double`, `Double[]`
* `Byte`, `Byte[]`
* `Boolean`, `Boolean[]`
* `Character`, `Character[]`

### 3. オブジェクト ###
以下のオブジェクトを保存/復元対象とすることができます。

* `String`, `String[]`
* `CharSequence`, `CharSequence[]`
* `Bundle`
* `Parcelable`, `Parcelable[]`
* `SparseArray<? extends Parcelable>`
* `ArrayList<String>`
* `ArrayList<Integer>`
* `ArrayList<CharSequence>`
* `ArrayList<Parcelable>`
* `Serializable`
* `Enum`

サポートする型(Preference)
------
### 1. プリミティブ型 ###
以下のプリミティブ型を保存/復元対象とすることができます。

* `int`
* `long`
* `float`
* `boolean`

### 2. ラッパーオブジェクト ###
プリミティブ型に対応するラッパーオブジェクトを保存/復元対象とすることができます。

* `Integer`
* `Long`
* `Float`
* `Boolean`

### 3. オブジェクト ###
以下のオブジェクトを保存/復元対象とすることができます。

* `String`
