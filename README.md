
# Image Progress Indicator
[![Release](https://jitpack.io/v/andreyneto/imageprogressindicator.svg)](https://jitpack.io/#andreyneto/imageprogressindicator/1.0.1)

![Sample](https://github.com/andreyneto/imageprogressindicator/blob/master/sample.jpeg?raw=true)
##  Gradle
**Step 1.** Add the JitPack repository to your build file.
Add it in your root build.gradle at the end of repositories:
```css
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
**Step 2.**  Add the dependency

```css
dependencies {
	implementation 'com.github.andreyneto:imageprogressindicator:1.0.1'
}
```
## Usage
**Step 1.** Add view to layout
```xml
<app.sorocaba.imageprogressindicator.ImageProgressIndicator
	android:id="@+id/image_progress_indicator"
	android:layout_width="match_parent"
	android:layout_height="wrap_content"/>
```
**Step 2.** Initialize with params
```kotlin
val mValue: Int = 13 //progress value to show
val mUrl: String = "https://avatars3.githubusercontent.com/u/2815005?s=460&v=4" //avatar url
image_progress_indicator.init(percentage = mValue, url = mUrl)
```
**Step 3. (Optional)** Update values
```kotlin
image_progress_indicator.setImage(newUrl) // to update avatar image
```
or 
```kotlin
image_progress_indicator.setProgress(newValue) // to update progress percentage
```
## Example
Clone this repository and open in Android Studio to run a working example.
