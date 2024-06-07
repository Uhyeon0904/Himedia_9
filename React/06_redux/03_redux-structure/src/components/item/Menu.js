import { useEffect } from "react";
import { useDispatch } from "react-redux";
import { callGetMenuAPI } from "../../api/MenuAPICalls";

function Menu({id}) {

    const dispatch = useDispatch();

    useEffect( () => {
        dispatch(callGetMenuAPI(id));
    }, [])

    return (
      <>
      </>  
    );
}
export default Menu;