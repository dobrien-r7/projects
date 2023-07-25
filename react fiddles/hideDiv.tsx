
import React, { useState } from "react";

const myFunc = () => {
    const [toggle, setToggle] = useState(false);

    const handleHideData = () => {
        setToggle(!toggle);
    };

    return (
        <div className="btn">
            <button id="veriGoster" onClick={handleHideData}>
                Show
            </button>

            {toggle && (
                <div className="apis">
                    hide and seek
                </div>
            )}
        </div>
    );
};

export default myFunc;