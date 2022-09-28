<p align="center"><img src="https://github.com/CuteLibs/CuteNoCon/raw/master/files/20220928_112028_0000.png" height="70" alt="GitHub forks"> <img src="https://github.com/CuteLibs/CuteNoCon/raw/master/files/20220928_112058_0000.png" height="80" alt="Cute Dialog"> </p>

<p align="center"> <a href="https://www.android.com"><img src="https://img.shields.io/badge/platform-Android-yellow.svg" alt="platform"></a>
 <a href="https://android-arsenal.com/api?level=21"><img src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat" alt="API"></a> <a href="https://jitpack.io/#CuteLibs/CuteNoCon/"><img src="https://jitpack.io/v/CuteLibs/CuteNoCon.svg" alt="JitPack"></a> <a href="https://github.com/CuteLibs/CuteNoCon/blob/master/LICENSE"><img src="https://img.shields.io/github/license/CuteLibs/CuteNoCon" alt="GitHub license"></a> </p>
 
 
<h3 align="center"><b>A Custom Material Design No Internet Dialog Library for Android</b></h3>



 <p align="center"> <a href="https://github.com/CuteLibs/CuteNoCon/issues"><img src="https://img.shields.io/github/issues/CuteLibs/CuteNoCon" alt="GitHub issues"></a> <a href="https://github.com/CuteLibs/CuteNoCon/network"><img src="https://img.shields.io/github/forks/CuteLibs/CuteNoCon" alt="GitHub forks"></a> <a href="https://github.com/CuteLibs/CuteNoCon/stargazers"><img src="https://img.shields.io/github/stars/CuteLibs/CuteNoCon" alt="GitHub stars"></a> <a href="https://github.com/CuteLibs/CuteNoCon/graphs/contributors"> <img src="https://img.shields.io/github/contributors/CuteLibs/CuteNoCon" alt="GitHub contributors"></a> <img src="https://img.shields.io/github/languages/code-size/CuteLibs/CuteNoCon" alt="Code Size">  </p>
  
 <p align="center"> <img src="https://github.com/CuteLibs/CuteNoCon/actions/workflows/android.yml/badge.svg" alt="Build"/> <a href="https://www.codacy.com/gh/CuteLibs/CuteNoCon/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=CuteLibs/CuteNoCon&amp;utm_campaign=Badge_Grade"><img src="https://app.codacy.com/project/badge/Grade/b46743b23bf041819fb5232ba87fb17e" alt="Code Quality"></a> <a href="https://www.codefactor.io/repository/github/cutelibs/CuteNoCon"><img src="https://www.codefactor.io/repository/github/cutelibs/CuteNoCon/badge" alt="CodeFactor" /></a> </p>

<br/>


## Purpose


## Features


## Screenshot

| Icon | Image | Animation |
|---------|--------|----------|




## Demo
<a href="https://github.com/CuteLibs/CuteDialog/raw/master/files/Cute%20Dialog.apk">Download</a> and Give it a try.


## Prerequisites

#### Old
If you're using old gradle versions then follow this.
Add this in your root `build.gradle` :

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

#### New
If you're using new gradle versions then follow this.
Add this in your `settings.gradle` file:

```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
       ...
        maven { url 'https://jitpack.io' }

    }
}
```

## Theme
For using <b>CuteDialog</b> in your project, you must use <b>Material Theme</B> in your project. You can use <b>CuteDialog</b> in both <b>Material</b>  <b>Light</b> and <b>Dark</b> theme.

For example:
    
 ```xml

    <style name="AppTheme" parent="Theme.MaterialComponents.Light.DarkActionBar">
	    
        <!-- Customize your theme here. -->
	    
    </style>
```
Or

```xml

    <style name="AppTheme" parent="Theme.MaterialComponents.DayNight.DarkActionBar">
	    
        <!-- Customize your theme here. -->
	    
    </style>

```


## Dependencies
Add this to your app level `build.gradle`:

(Always use the latest version. Current Latest version is <a href="https://jitpack.io/#CuteLibs/CuteNoCon"><img src="https://jitpack.io/v/CuteLibs/CuteNoCon.svg" alt="JitPack"></a> )

```gradle
dependencies {
	...
	     


}
```
## Usage

## Customizations

## Attributes 

## Contribute
Please fork this repository and contribute back using [pull requests](https://github.com/CuteLibs/CuteNoCon/pulls).

Any contributions, large or small, major features, bug fixes, are welcomed and appreciated.

Let me know which features you want in the future in `Request Feature` tab. 

If this project helps you a little bit, then give a to Star ⭐ the Repo. 

## Credits

Created with ❤️ by <a href="https://github.com/CuteLibs"> CuteLibs </a> & <a href="https://github.com/ahmmedrejowan"> K M Rejowan Ahmmed </a>

* Animation - [Lottie for Android](https://github.com/airbnb/lottie-android) library

## License
* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

```
Copyright 2022 CuteLibs

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

```


