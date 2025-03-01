# Avoid using high accuracy geolocation in web applications (`@ecocode/avoid-high-accuracy-geolocation`)

⚠️ This rule _warns_ in the ✅ `recommended` config.

<!-- end auto-generated rule header -->

## Rule details

This rule aims at reducing CPU consumption by telling the device to use a less accurate yet more eco friendly geolocation, when geolocation API is used.

## Examples

Examples of **non compliant** code for this rule:

```js
var options = { enableHighAccuracy: true, timeout: 5000, maximumAge: 0 };
function success(pos) {
  console.log(pos.coords);
}

function error(err) {
  console.warn(err);
}

navigator.geolocation.getCurrentPosition(success, error, options);
```

Examples of **compliant** code for this rule:

```js
// enableHighAccuracy is false by default, so not declaring it is correct
function success(pos) {
  console.log(pos);
}
navigator.geolocation.getCurrentPosition(success);
```

```js
var options = { enableHighAccuracy: false, timeout: 5000, maximumAge: 0 };
function success(pos) {
  console.log(pos.coords);
}

function error(err) {
  console.warn(err);
}

navigator.geolocation.getCurrentPosition(success, error, options);
```
