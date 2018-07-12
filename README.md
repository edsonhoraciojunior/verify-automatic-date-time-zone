---
title: Verify Automatic Date, Time and Timezone
description: Verify if Date, Time and Timezone are set to automatic sync with network provider.
---

## Installation

    cordova plugin add verify-automatic-date-time-zone

## VerifyAutomaticDateTimeZone.isAutomaticChecked

Returns a boolean indicating if automatic is enabled for date, time and timezone

### Supported Platforms

- Android

### Quick Example

```js
window.VerifyAutomaticDateTimeZone.isAutomaticChecked(function(isIt){
  if (isIt == 'true') {
        // do something
    } else {
        // do something else
    }
});
```

### iOS not supported

Couldn't find out how to get iOS settings programatically so it's pending