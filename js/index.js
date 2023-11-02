const OBJECT_SIZE = 500;
const obj = {};

for (let i = 0; i < OBJECT_SIZE; i++) {
    obj["double_key" + i] = Math.random();
    obj["str_key" + i] = '#'.repeat(50);
};

function jsonParseStringify(){
    return JSON.parse(JSON.stringify(obj));
};

module.exports = {
    jsonParseStringify
};