import { Route, Routes } from "react-router-dom";
import AdminPhotos from "../ComponentsM/AdminPhotos";
import { useNavigate } from "react-router-dom";
import React, {useState} from "react";

export default function AdminPage(){
    /** edit photos
     *      add photo
     *      remove photo
     *      edit tags on photo/category
     */ 
    /** edit categories
     *      add cat
     *      remove cat
     *      edit cats into
     */
    /** edit tags 
     *      add tag
     *      remove tag
     *      edit tags info
     */
    /** orders 
     *      get all orders
     *      count of orders yearly, monthly, and total
     */
    /** users
     *      get all users
     *      give users photos
     *      remove users photos
     *      give user admin
     *      remove user admin privileges password protected
     */

    /** STYLE
     * NAVBAR 
     * left side column with photos, categories, tags, orders, and users buttons.
     *      each button is spaced evenly on the column taking up all the space.
     *      default active button will be the last one he was on.  If its his first time then its orders page.
     *      active page button will stand out from others
     * PHOTOS
     * CATEGORIES
     * TAGS
     * ORDERS
     * USERS
     */

    type ActiveButton = "Photos" | "Categories" | "Tags" | "Orders" | "Users";
    const navigate = useNavigate();
    const [activeButton, setActiveButton] = useState<ActiveButton>("Orders");
    const whatButtonClicked = (e: React.MouseEvent)=>{
        const value: any = e.currentTarget.textContent;
        navigate(`${e.currentTarget.innerHTML}`);
        setActiveButton(value);
    }
    
    const buttonClass = (btnName: ActiveButton)=>{
        switch(activeButton){
            case btnName : return "border h-full bg-slate-400";
            default : return "border h-full hover:bg-slate-400";
        }
    }

    return (
        <main className="flex">
            <section className="flex flex-col w-72 h-screen justify-evenly">
                <button className={buttonClass("Photos")} onClick={whatButtonClicked}>Photos</button>
                <button className={buttonClass("Categories")} onClick={whatButtonClicked}>Categories</button>
                <button className={buttonClass("Tags")} onClick={whatButtonClicked}>Tags</button>
                <button className={buttonClass("Orders")} onClick={whatButtonClicked}>Orders</button>
                <button className={buttonClass("Users")} onClick={whatButtonClicked}>Users</button>
            </section>
            <Routes>
                <Route path="Photos" element={<AdminPhotos/>}/>
                <Route path="Categories" element={<AdminPhotos/>}/>
                <Route path="Tags" element={<AdminPhotos/>}/>
                <Route path="Orders" element={<AdminPhotos/>}/>
                <Route path="Users" element={<AdminPhotos/>}/>
            </Routes>
        </main>

    )
};