BundleSaver
======================
Android用ユーティリティ。  
Bundleへの保存/復元を自動化してくれます。
 
使い方
------
### 1. BundleSaverの読み込み ###
BundleSaverを利用したいプロジェクトにBundleSaverプロジェクトもしくは、  
jarファイルをビルドパスに通してください。

 
### 2. Activityでの使い方 ###
BundleSaverを利用したいActivityで、以下を参考に実装を行ってください。
    
    // Bundleへの保存/復元したいインスタンス変数に
    // BundleTargetアノテーションを設定します。
    @BundleTarget
    int count;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        
        try{
            // BundleTargetアノテーションが設定されたインスタンス変数を
            // Bundleへ保存します。
            AutoBundleSaver.getAutoBundleSaver().save(outState`, this);
            
        }catch(NotSupportedBundleTypeException e){
            // Bundleへ保存できない型を指定した場合、
            // 実行時例外が発生します。
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // BundleTargetアノテーションが設定されたインスタンス変数へ
        // Bundleの値を復元します。
        AutoBundleSaver.getAutoBundleSaver().restore(savedInstanceState`, this);
    }

サポートする型
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