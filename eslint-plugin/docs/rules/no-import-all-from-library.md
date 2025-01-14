# Should not import all from library (`@ecocode/no-import-all-from-library`)

⚠️ This rule _warns_ in the ✅ `recommended` config.

<!-- end auto-generated rule header -->

## Rule details

This rule aims to reduce weight of programs by using only needed modules. Many libraries export only one module by
default, but some of them are exporting ES modules or submodules. We should use them to select more precisly needed
modules and avoid unnecessarily overloading files weight.

## Options

You can externally add your own libraries to be checked.
To add your own libraries you need to modify your .eslintrc.js by adding the following rule configuration:

```js
module.exports = {
  ...yourConf,
  rules: {
    "no-import-all-from-library": [
      "warn",
      {
        notAllowedLibraries: ["some-lib"], // will check for -> import someLib from "some-lib"
        importByNamespaceNotAllowedLibraries: ["some-other-lib"], // will check for -> import * as someOtherLib from "some-other-lib"
      },
    ],
  },
};
```

## Examples

Examples of **non-compliant** code for this rule:

```js
// Example with lodash
import lodash from "lodash";
import { isEmpty } from "lodash";
import * as lodash from "lodash";

// Example with underscore
import _ from "underscore";
```

**Size of your bundle, if you use the whole lodash library:**

* **index.js - 531.46 KB**
    * node_modules/lodash - 531.35 KB
        * lodash.js - 531.35 KB
    * index.js - 112 B

---

Examples of **compliant** code for this rule:

```js
// Example with lodash (uses submodules)
import isEmpty from "lodash/isEmpty";
import intersect from "lodash/intersect";

// Example with underscore (uses esm modules)
import map from "underscore/modules/map.js";
```

Size of your bundle, if you use only the "isEmpty" method:

* **index.js - 24.42 KB**
    * node_modules/lodash - 24.31 KB
        * isEmpty - 1.95 KB
        * _nodeUtil.js - 995 B
        * isArrayLike.js - 830 B
        * ...
    * index.js - 110 B
